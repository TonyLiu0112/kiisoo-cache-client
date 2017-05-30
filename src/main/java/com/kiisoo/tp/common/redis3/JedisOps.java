package com.kiisoo.tp.common.redis3;

import redis.clients.jedis.Jedis;

public interface JedisOps extends Ops {

	Jedis getResource();
	
}
