package com.stemcell.redis3;

import java.util.HashSet;
import java.util.Set;

import com.kiisoo.tp.common.redis3.RedisClient;
import com.kiisoo.tp.common.redis3.conf.RedisConfiguration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

/**
 * redis3 test
 * @author liuboyu
 *
 */
public class Test {
	
	private static JedisCluster cluster;

	@SuppressWarnings("serial")
	public static void main(String[] args) {
        RedisConfiguration redisConfiguration = new RedisConfiguration();
        redisConfiguration.setModel("pool");
        redisConfiguration.setHostAndPort("192.168.0.215:6379");
        RedisClient.instance(redisConfiguration);
        RedisClient.set("茶杯", "心机婊");
        System.out.println(RedisClient.get("茶杯"));
    }
	
}
