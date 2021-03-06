package com.hanyi.ordinary.common.selector;

import cn.hutool.core.util.StrUtil;
import com.hanyi.ordinary.common.annotation.EnableThreadPool;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

/**
 * <p>
 * 线程池配置注入器
 * </p>
 *
 * @author wenchangwei@wistronits.com
 * @since 11:25 2020/7/24
 */
public class ThreadPoolConfigurationImportSelector implements ImportBeanDefinitionRegistrar {

    /**
     * 向容器中注入bean对象
     *
     * @param annotationMetadata 元数据
     * @param registry           bean注册器
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {
        Set<String> annotationTypes = annotationMetadata.getAnnotationTypes();
        Class<ThreadPoolConfigurationImportSelector> clazz = ThreadPoolConfigurationImportSelector.class;
        annotationTypes.forEach(s -> {
            if (s.contains(EnableThreadPool.class.getSimpleName())) {
                RootBeanDefinition beanDefinition = new RootBeanDefinition(clazz);
                //设置自定义属性
                beanDefinition.setSynthetic(true);
                String lowerFirst = StrUtil.lowerFirst(clazz.getSimpleName());
                registry.registerBeanDefinition(lowerFirst, beanDefinition);
            }
        });
    }

}
