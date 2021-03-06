package com.hanyi.ordinary.common.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>
 * 线程池属性配置类
 * </p>
 *
 * @author wenchangwei
 * @since 10:02 下午 2020/7/24
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "business.thread-pool-executor")
public class ThreadPoolProperties {

    /**
     * 表示线程池核心线程，正常情况下开启的线程数量
     */
    private int corePoolSize = 5;

    /**
     * 如果queueCapacity存满了，还有任务就会启动更多的线程，
     * 直到线程数达到maxPoolSize。如果还有任务，则根据拒绝策略进行处理
     */
    private int maxPoolSize = 10;

    /**
     * 线程名称前缀
     */
    private String threadNamePrefix = "thread-pool-business";

}
