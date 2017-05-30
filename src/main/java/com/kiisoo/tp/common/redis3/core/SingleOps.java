package com.kiisoo.tp.common.redis3.core;

import com.kiisoo.tp.common.redis3.JedisOps;
import com.kiisoo.tp.common.redis3.RedisBuilder;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;
import redis.clients.jedis.JedisShardInfo;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * redis 单机操作类 非线程安全
 *
 * @author Tony
 * @date Dec 12, 2015
 */
public class SingleOps implements JedisOps {

    private Jedis jedis;

    public SingleOps(Map<String, String> confMap) {
        jedis = this.new SingleBuilder().builder(confMap);
    }

    @Override
    public Jedis getResource() {
        return jedis;
    }

    @Override
    public void close() throws IOException {
        jedis.close();
    }

    @Override
    public Long del(String key) {
        return jedis.del(key);
    }

    @Override
    public boolean exists(String key) {
        return jedis.exists(key);
    }

    @Override
    public Long expire(String key, int seconds) {
        return jedis.expire(key, seconds);
    }

    @Override
    public Long pexpire(String key, long milliseconds) {
        return jedis.pexpire(key, milliseconds);
    }

    @Override
    public Long decrBy(String key, long integer) {
        return jedis.decrBy(key, integer);
    }

    @Override
    public String type(String key) {
        return jedis.type(key);
    }

    @Override
    public String watch(String... key) {
        return jedis.watch(key);
    }

    @Override
    public String unwatch() {
        return jedis.unwatch();
    }

    @Override
    public String set(String key, String value) {
        return jedis.set(key, value);
    }

    @Override
    public String set(String key, String value, String nxxx, String expx, long time) {
        return jedis.set(key, value, nxxx, expx, time);
    }

    @Override
    public String get(String key) {
        return jedis.get(key);
    }

    @Override
    public List<String> hmget(String key, String... keys) {
        return jedis.hmget(key, keys);
    }

    @Override
    public Long setnx(String key, String value) {
        return jedis.setnx(key, value);
    }

    @Override
    public Long append(String key, String value) {
        return jedis.append(key, value);
    }

    @Override
    public String lset(String key, long index, String list) {
        return jedis.lset(key, index, list);
    }

    @Override
    public String lpop(String key) {
        return jedis.lpop(key);
    }

    @Override
    public Long llen(String key) {
        return jedis.llen(key);
    }

    @Override
    public List<String> lrange(String key, int start, int end) {
        return jedis.lrange(key, start, end);
    }

    @Override
    public Map<String, String> hgetall(String key) {
        return jedis.hgetAll(key);
    }

    @Override
    public Long hset(String key, String field, String value) {
        return jedis.hset(key, field, value);
    }

    @Override
    public String hget(String key, String field) {
        return jedis.hget(key, field);
    }

    @Override
    public boolean hexists(String key, String field) {
        return jedis.hexists(key, field);
    }

    @Override
    public Long hlen(String key) {
        return jedis.hlen(key);
    }

    @Override
    public Long hdel(String key, String... fields) {
        return jedis.hdel(key, fields);
    }

    @Override
    public List<String> hvals(String key) {
        return jedis.hvals(key);
    }

    @Override
    public Set<String> hkeys(String key) {
        return jedis.hkeys(key);
    }

    @Override
    public Long sadd(String key, String... members) {
        return jedis.sadd(key, members);
    }

    @Override
    public Long scard(String key) {
        return jedis.scard(key);
    }

    @Override
    public Set<String> smembers(String key) {
        return jedis.smembers(key);
    }

    @Override
    public Long srem(String key, String... member) {
        return jedis.srem(key, member);
    }

    @Override
    public boolean sismember(String key, String member) {
        return jedis.sismember(key, member);
    }

    @Override
    public void subscribe(JedisPubSub jedisPubSub, String... channels) {
        jedis.subscribe(jedisPubSub, channels);
    }

    @Override
    public Long publish(String channel, String message) {
        return jedis.publish(channel, message);
    }

    @Override
    public String set(byte[] key, byte[] value) {
        return jedis.set(key, value);
    }

    @Override
    public byte[] get(byte[] key) {
        return jedis.get(key);
    }

    @Override
    public Long del(byte[] key) {
        return jedis.del(key);
    }

    /**
     * 单机模式生成器
     * <p>
     *
     * @author Tony
     * @date Dec 12, 2015
     */
    public class SingleBuilder implements RedisBuilder<Jedis> {

        @Override
        public Jedis builder(Map<String, String> confMap) {
            String[] hostPort = confMap.get("hostAndPort").split(":");
            JedisShardInfo jedisShardInfo = new JedisShardInfo(hostPort[0], Integer.parseInt(hostPort[1]));
            jedisShardInfo.setPassword(confMap.get("pass"));
            return new Jedis(jedisShardInfo);
        }

    }

}
