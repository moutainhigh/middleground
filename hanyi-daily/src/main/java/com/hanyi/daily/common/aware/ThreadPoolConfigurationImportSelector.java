package com.hanyi.daily.common.aware;

import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

/**
 * <p>
 *
 * </p>
 *
 * @author wenchangwei@wistronits.com
 * @since 11:25 2020/7/24
 */
public class ThreadPoolConfigurationImportSelector implements ImportBeanDefinitionRegistrar {

    private static final String ANNOTATION = "EnableThreadPool";

    /**
     * 向容器中注入bean对象
     *
     * @param annotationMetadata 元数据
     * @param registry           bean注册器
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {
        Set<String> annotationTypes = annotationMetadata.getAnnotationTypes();
        annotationTypes.forEach(s -> {
            if (s.contains(ANNOTATION)) {
                Class<? extends ThreadPoolConfigurationImportSelector> clazz = this.getClass();
                AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(clazz).getBeanDefinition();
                String simpleName = StrUtil.lowerFirst(clazz.getSimpleName());
                registry.registerBeanDefinition(simpleName, beanDefinition);
            }
        });
    }
}