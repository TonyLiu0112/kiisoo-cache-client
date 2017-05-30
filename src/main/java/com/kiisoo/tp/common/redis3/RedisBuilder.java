package com.kiisoo.tp.common.redis3;

import java.util.Map;


/**
 * 配置接口
 * <p>
 *
 * @author Tony
 * @date Dec 12, 2015
 */
public interface RedisBuilder<T> {

    T builder(Map<String, String> confMap);

}
