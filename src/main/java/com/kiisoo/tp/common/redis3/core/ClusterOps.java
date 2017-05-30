package com.kiisoo.tp.common.redis3.core;

import com.kiisoo.tp.common.redis3.Ops;
import com.kiisoo.tp.common.redis3.RedisBuilder;
import jodd.util.StringUtil;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPubSub;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * redis集群操作
 * 
 * @author Tony
 * @date Dec 12, 2015
 */
public class ClusterOps implements Ops {

	private JedisCluster cluster;
	
	public ClusterOps(Map<String, String> confMap) {
		cluster = this.new ClusterBuilder().builder(confMap);
	}

	@Override
	public Long del(String key) {
		return cluster.del(key);
	}

	@Override
	public boolean exists(String key) {
		return cluster.exists(key);
	}

	@Override
	public Long expire(String key, int seconds) {
		return cluster.expire(key, seconds);
	}

	@Override
	public Long pexpire(String key, long milliseconds) {
		return cluster.pexpire(key, milliseconds);
	}

	@Override
	public Long decrBy(String key, long integer) {
		return cluster.decrBy(key, integer);
	}

    @Override
    public String type(String key) {
        return cluster.type(key);
    }

    @Override
    @Deprecated
    public String watch(String... key) {
        return null;
    }

    @Override
    @Deprecated
    public String unwatch() {
        return null;
    }

    @Override
	public String set(String key, String value) {
		return cluster.set(key, value);
	}

	@Override
	public String set(String key, String value, String nxxx, String expx, long time) {
		return cluster.set(key, value, nxxx, expx, time);
	}

	@Override
	public String get(String key) {
		return cluster.get(key);
	}

	@Override
	public List<String> hmget(String key, String... keys) {
		return cluster.hmget(key, keys);
	}

	@Override
	public Long setnx(String key, String value) {
		return cluster.setnx(key, value);
	}

	@Override
	public Long append(String key, String value) {
		return cluster.append(key, value);
	}

	@Override
	public String lset(String key, long index, String list) {
		return cluster.lset(key, index, list);
	}

	@Override
	public String lpop(String key) {
		return cluster.lpop(key);
	}

	@Override
	public Long llen(String key) {
		return cluster.llen(key);
	}

    @Override
    public List<String> lrange(String key, int start, int end) {
        return cluster.lrange(key, start, end);
    }

    @Override
	public Map<String, String> hgetall(String key) {
		return cluster.hgetAll(key);
	}

	@Override
	public Long hset(String key, String field, String value) {
		return cluster.hset(key, field, value);
	}

	@Override
	public String hget(String key, String field) {
		return cluster.hget(key, field);
	}

	@Override
	public boolean hexists(String key, String field) {
		return cluster.hexists(key, field);
	}

	@Override
	public Long hlen(String key) {
		return cluster.hlen(key);
	}

	@Override
	public Long hdel(String key, String... fields) {
		return cluster.hdel(key, fields);
	}

    @Override
    public List<String> hvals(String key) {
        return cluster.hvals(key);
    }

    @Override
    public Set<String> hkeys(String key) {
        return cluster.hkeys(key);
    }

    @Override
	public Long sadd(String key, String... members) {
		return cluster.sadd(key, members);
	}

	@Override
	public Long scard(String key) {
		return cluster.scard(key);
	}

	@Override
	public Set<String> smembers(String key) {
		return cluster.smembers(key);
	}

	@Override
	public Long srem(String key, String... member) {
		return cluster.srem(key, member);
	}

	@Override
	public boolean sismember(String key, String member) {
		return cluster.sismember(key, member);
	}

    @Override
    public void subscribe(JedisPubSub jedisPubSub, String... channels) {
        cluster.subscribe(jedisPubSub, channels);
    }

    @Override
    public Long publish(String channel, String message) {
        return cluster.publish(channel, message);
    }

	@Override
	public String set(byte[] key, byte[] value) {
		return cluster.set(key, value);
	}

	@Override
	public byte[] get(byte[] key) {
		return cluster.get(key);
	}

	@Override
	public Long del(byte[] key) {
		return cluster.del(key);
	}

	@Override
	public void close() throws IOException {
		// NO OPS
	}

	/**
	 * 集群对象生成器
	 * 
	 * @author Tony
	 * @date   Dec 12, 2015
	 */
	public class ClusterBuilder implements RedisBuilder<JedisCluster> {

		@SuppressWarnings("serial")
		@Override
		public JedisCluster builder(Map<String, String> confMap) {
			final String[] hosts = confMap.get("hostAndPort").split(",");

			if (hosts.length < 6)
				throw new IllegalStateException(String.format("[current error] : The host&port of config must be more than 6 nodes."));

			if (StringUtil.isBlank(confMap.get("maxRedirections")))
				throw new IllegalStateException("maxRedirections can not be null");

			if (StringUtil.isBlank(confMap.get("timeOut")))
				throw new IllegalStateException("timeOut can not be null");

			Set<HostAndPort> nodes = new HashSet<HostAndPort>() {
				{
					for (String host : hosts) {
						String[] item = host.split(":");
						add(new HostAndPort(item[0], Integer.parseInt(item[1])));
					}
				}
			};
			return new JedisCluster(nodes, Integer.parseInt(confMap.get("timeOut")), Integer.parseInt(confMap.get("maxRedirections")));
		}

	}

}
