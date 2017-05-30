package com.kiisoo.tp.common.redis3;

import redis.clients.jedis.JedisPubSub;

import java.io.Closeable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * redis操作接口
 * <p>
 * 操作接口分为<br>
 * <li>单机模式: 非线程安全，并发情况下不可用.</li>
 * <li>连接池模式: 线程安全，应根据需求添加池内连接数量.</li>
 * <li>集群模式: 线程安全.</li>
 *
 * @author Tony
 * @date Dec 12, 2015
 */
public interface Ops extends Closeable {

    /*
     * * * * * * public operation * * * * * *
     */
    Long del(final String key);

    boolean exists(final String key);

    Long expire(String key, int seconds);

    Long pexpire(final String key, final long milliseconds);

    Long decrBy(final String key, final long integer);

    String type(final String key);

    String watch(final String... key);

    String unwatch();

    /*
     * * * * * * string operation * * * * * *
     */
    String set(final String key, final String value);

    String set(final String key, final String value, final String nxxx, final String expx, long time);

    String get(final String key);

    List<String> hmget(String key, String... keys);

    Long setnx(String key, String value);

    Long append(String key, String value);

    /*
     * * * * * * list operation * * * * * *
     */
    String lset(final String key, final long index, final String list);

    String lpop(final String key);

    Long llen(String key);

    List<String> lrange(final String key, final int start, final int end);

    /*
     * * * * * * hash operation * * * * * *
     */
    Map<String, String> hgetall(final String key);

    Long hset(final String key, String field, String value);

    String hget(final String key, final String field);

    boolean hexists(final String key, final String field);

    Long hlen(final String key);

    Long hdel(final String key, final String... field);

    List<String> hvals(final String key);

    Set<String> hkeys(final String key);

    /*
     * * * * * * set operation * * * * * *
     */
    Long sadd(String key, String... member);

    Long scard(String key);

    Set<String> smembers(String key);

    Long srem(String key, String... member);

    boolean sismember(String key, String member);

    /**
     * * * * * * pub/sub ops * * * * * * *
     */
    void subscribe(final JedisPubSub jedisPubSub, final String... channels);

    Long publish(String channel, String message);

    /**
     * * * * * * binary ops * * * * * * *
     */
    String set(byte[] key, byte[] value);

    byte[] get(byte[] key);

    Long del(byte[] key);

}
