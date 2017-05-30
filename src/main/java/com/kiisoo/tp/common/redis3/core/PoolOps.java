package com.kiisoo.tp.common.redis3.core;

import com.kiisoo.tp.common.redis3.JedisOps;
import com.kiisoo.tp.common.redis3.RedisBuilder;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;
import redis.clients.jedis.Protocol;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 连接池操作
 *
 * @author Tony
 * @date Dec 12, 2015
 */
public class PoolOps implements JedisOps {

    Logger logger = LoggerFactory.getLogger(getClass());

    private JedisPool jedisPool;

    public PoolOps(Map<String, String> confMap) {
        jedisPool = this.new PoolBuilder().builder(confMap);
    }

    @Override
    public Jedis getResource() {
        return jedisPool.getResource();
    }

    @Override
    public Long del(String key) {
        Jedis jedis = getResource();
        try {
            return jedis.del(key);
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }

    @Override
    public boolean exists(String key) {
        Jedis jedis = getResource();
        try {
            return jedis.exists(key);
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }

    @Override
    public Long expire(String key, int seconds) {
        Jedis jedis = getResource();
        try {
            return jedis.expire(key, seconds);
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }

    @Override
    public Long pexpire(String key, long milliseconds) {
        Jedis jedis = getResource();
        try {
            return jedis.pexpire(key, milliseconds);
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }

    @Override
    public Long decrBy(String key, long integer) {
        Jedis jedis = getResource();
        try {
            return jedis.decrBy(key, integer);
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }

    @Override
    public String type(String key) {
        Jedis jedis = getResource();
        try {
            return jedis.type(key);
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }

    @Override
    public String watch(String... key) {
        Jedis jedis = getResource();
        try {
            return jedis.watch(key);
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }

    @Override
    public String unwatch() {
        Jedis jedis = getResource();
        try {
            return jedis.unwatch();
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }

    @Override
    public String set(String key, String value) {
        Jedis jedis = getResource();
        try {
            return jedis.set(key, value);
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }

    @Override
    public String set(String key, String value, String nxxx, String expx, long time) {
        Jedis jedis = getResource();
        try {
            return jedis.set(key, value, nxxx, expx, time);
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }

    @Override
    public String get(String key) {
        Jedis jedis = getResource();
        try {
            return jedis.get(key);
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }

    @Override
    public List<String> hmget(String key, String... keys) {
        Jedis jedis = getResource();
        try {
            return jedis.hmget(key, keys);
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }

    @Override
    public Long setnx(String key, String value) {
        Jedis jedis = getResource();
        try {
            return jedis.setnx(key, value);
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }

    @Override
    public Long append(String key, String value) {
        Jedis jedis = getResource();
        try {
            return jedis.append(key, value);
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }

    @Override
    public String lset(String key, long index, String value) {
        Jedis jedis = getResource();
        try {
            return jedis.lset(key, index, value);
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }

    @Override
    public String lpop(String key) {
        Jedis jedis = getResource();
        try {
            return jedis.lpop(key);
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }

    @Override
    public Long llen(String key) {
        Jedis jedis = getResource();
        try {
            return jedis.llen(key);
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }

    @Override
    public List<String> lrange(String key, int start, int end) {
        Jedis jedis = getResource();
        try {
            return jedis.lrange(key, start, end);
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }

    @Override
    public Map<String, String> hgetall(String key) {
        Jedis jedis = getResource();
        try {
            return jedis.hgetAll(key);
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }

    @Override
    public Long hset(String key, String field, String value) {
        Jedis jedis = getResource();
        try {
            return jedis.hset(key, field, value);
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }

    @Override
    public String hget(String key, String field) {
        Jedis jedis = getResource();
        try {
            return jedis.hget(key, field);
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }

    @Override
    public boolean hexists(String key, String field) {
        Jedis jedis = getResource();
        try {
            return jedis.hexists(key, field);
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }

    @Override
    public Long hlen(String key) {
        Jedis jedis = getResource();
        try {
            return jedis.hlen(key);
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }

    @Override
    public Long hdel(String key, String... field) {
        Jedis jedis = getResource();
        try {
            return jedis.hdel(key, field);
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }

    @Override
    public List<String> hvals(String key) {
        Jedis jedis = getResource();
        try {
            return jedis.hvals(key);
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }

    @Override
    public Set<String> hkeys(String key) {
        Jedis jedis = getResource();
        try {
            return jedis.hkeys(key);
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }

    @Override
    public Long sadd(String key, String... member) {
        Jedis jedis = getResource();
        try {
            return jedis.sadd(key, member);
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }

    @Override
    public Long scard(String key) {
        Jedis jedis = getResource();
        try {
            return jedis.scard(key);
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }

    @Override
    public Set<String> smembers(String key) {
        Jedis jedis = getResource();
        try {
            return jedis.smembers(key);
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }

    @Override
    public Long srem(String key, String... member) {
        Jedis jedis = getResource();
        try {
            return jedis.srem(key, member);
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }

    @Override
    public boolean sismember(String key, String member) {
        Jedis jedis = getResource();
        try {
            return jedis.sismember(key, member);
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }

    @Override
    public void subscribe(JedisPubSub jedisPubSub, String... channels) {
        Jedis jedis = getResource();
        try {
            jedis.subscribe(jedisPubSub, channels);
        } finally {
            if (jedis != null) jedis.close();
        }
    }

    @Override
    public Long publish(String channel, String message) {
        Jedis jedis = getResource();
        try {
            return jedis.publish(channel, message);
        } finally {
            if (jedis != null) jedis.close();
        }
    }

    @Override
    public String set(byte[] key, byte[] value) {
        Jedis jedis = getResource();
        try {
            return jedis.set(key, value);
        } finally {
            if (jedis != null) jedis.close();
        }
    }

    @Override
    public byte[] get(byte[] key) {
        Jedis jedis = getResource();
        try {
            return jedis.get(key);
        } finally {
            if (jedis != null) jedis.close();
        }
    }

    @Override
    public Long del(byte[] key) {
        Jedis jedis = getResource();
        try {
            return jedis.del(key);
        } finally {
            if (jedis != null) jedis.close();
        }
    }

    @Override
    public void close() throws IOException {
        jedisPool.close();
    }

    /**
     * 连接池对象生成器
     *
     * @author Tony
     * @date Dec 12, 2015
     */
    public class PoolBuilder implements RedisBuilder<JedisPool> {

        @Override
        public JedisPool builder(Map<String, String> confMap) {
            String[] hostAndPort = confMap.get("hostAndPort").split(":");
            GenericObjectPoolConfig conf = new GenericObjectPoolConfig();
            conf.setMaxIdle(Integer.parseInt(confMap.get("maxIdle")));
            conf.setMaxTotal(Integer.parseInt(confMap.get("maxTotal")));
            conf.setMaxWaitMillis(Long.parseLong(confMap.get("maxWaitMillis")));
            conf.setTestOnBorrow(true);
            return new JedisPool(conf, hostAndPort[0], Integer.parseInt(hostAndPort[1]), 100000, confMap.get("pass"),
                    Protocol.DEFAULT_DATABASE, null);
        }

    }

}
