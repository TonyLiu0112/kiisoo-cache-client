package com.kiisoo.tp.common.redis3.conf;

import com.kiisoo.tp.common.redis3.BaseRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 支持自动装配spring boot配置信息
 * <p>
 * Created by Tony on 22/03/2017.
 */
@Configuration
@EnableConfigurationProperties(RedisProperties.class)
@ConditionalOnClass(BaseRedis.class)
@ConditionalOnProperty(prefix = "redis", value = "enable", matchIfMissing = true)
public class SpringAutoConfiguration {

    private final RedisProperties redisProperties;

    @Autowired
    public SpringAutoConfiguration(RedisProperties redisProperties) {
        this.redisProperties = redisProperties;
    }

    @Bean
    @ConditionalOnMissingBean
    public BaseRedis buildBaseRedis() {
        RedisConfiguration redisConfiguration = new RedisConfiguration(redisProperties);
        BaseRedis baseRedis = new BaseRedis(redisConfiguration);
        baseRedis.start();
        return baseRedis;
    }
}
