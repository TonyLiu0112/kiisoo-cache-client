package com.kiisoo.tp.common.redis3;

import com.kiisoo.tp.common.redis3.conf.RedisConfiguration;
import redis.clients.jedis.JedisPubSub;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * redis操作静态客户端
 * <p/>
 *
 * @author Tony
 * @date Dec 12, 2015
 */
public class RedisClient {

    private static Ops ops;

    private RedisClient() {
    }

    public static void instance(RedisConfiguration configuration) {
        if (ops != null)
            return;
        new BaseRedis(configuration).start();
    }

    protected static void setOps(Ops opsInstance) {
        if (ops == null)
            ops = opsInstance;
    }

    public static Long del(String key) {
        return ops.del(key);
    }

    public static boolean exists(String key) {
        return ops.exists(key);
    }

    public static Long expire(String key, int seconds) {
        return ops.expire(key, seconds);
    }

    public static Long pexpire(String key, long milliseconds) {
        return ops.pexpire(key, milliseconds);
    }

    public static Long decrBy(String key, long integer) {
        return ops.decrBy(key, integer);
    }

    public static String set(String key, String value) {
        return ops.set(key, value);
    }

    public static String set(String key, String value, String nxxx, String expx, long time) {
        return ops.set(key, value, nxxx, expx, time);
    }

    public static String get(String key) {
        return ops.get(key);
    }

    public static List<String> hmget(String key, String... keys) {
        return ops.hmget(key, keys);
    }

    public static Long setnx(String key, String value) {
        return ops.setnx(key, value);
    }

    public static Long append(String key, String value) {
        return ops.append(key, value);
    }

    public static String lset(String key, long index, String list) {
        return ops.lset(key, index, list);
    }

    public static String lpop(String key) {
        return ops.lpop(key);
    }

    public static Long llen(String key) {
        return ops.llen(key);
    }

    public static Map<String, String> hgetall(String key) {
        return ops.hgetall(key);
    }

    public static Long hset(String key, String field, String value) {
        return ops.hset(key, field, value);
    }

    public static String hget(String key, String field) {
        return ops.hget(key, field);
    }

    public static boolean hexists(String key, String field) {
        return ops.hexists(key, field);
    }

    public static Long hlen(String key) {
        return ops.hlen(key);
    }

    public static Long hdel(String key, String... fields) {
        return ops.hdel(key, fields);
    }

    public static Set<String> hkeys(String key) {
        return ops.hkeys(key);
    }

    public static List<String> hvals(final String key) {
        return ops.hvals(key);
    }

    public static Long sadd(String key, String... members) {
        return ops.sadd(key, members);
    }

    public static Long scard(String key) {
        return ops.scard(key);
    }

    public static Set<String> smembers(String key) {
        return ops.smembers(key);
    }

    public static Long srem(String key, String... member) {
        return ops.srem(key, member);
    }

    public static boolean sismember(String key, String member) {
        return ops.sismember(key, member);
    }

    public static void subscribe(JedisPubSub jedisPubSub, String... channel) {
        ops.subscribe(jedisPubSub, channel);
    }

    public static Long publish(String channel, String message) {
        return ops.publish(channel, message);
    }

    public static String type(String key) {
        return ops.type(key);
    }

    public static List<String> lrange(String key, int start, int end) {
        return ops.lrange(key, start, end);
    }

    public static String watch(String... keys) {
        return ops.watch(keys);
    }

    public static String unwatch() {
        return ops.unwatch();
    }

    public static String set(byte[] key, byte[] value) {
        return ops.set(key, value);
    }

    public static byte[] get(byte[] key) {
        return ops.get(key);
    }

    public static Long del(byte[] key) {
        return ops.del(key);
    }
}
