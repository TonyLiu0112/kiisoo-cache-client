package com.kiisoo.tp.common.redis3.conf;

import java.util.HashMap;

/**
 * redis相关配置
 * <p>
 * Created by Tony on 4/25/16.
 */
public class RedisConfiguration extends HashMap<String, String> {

    private RedisProperties redisProperties;

    public RedisConfiguration() {
        this(new RedisProperties());
    }

    public RedisConfiguration(RedisProperties redisProperties) {
        super();
        this.redisProperties = redisProperties;
    }

    public void doBind() {
        model();
        hostPort();
        timeOut();
        maxRedirections();
        maxIdle();
        maxTotal();
        maxWaitMillis();
        pass();
    }

    /**
     * 配置redis客户端模式
     * <li>单机: single</li>
     * <li>连接池:pool </li>
     * <li>集群: cluster</li>
     */
    private RedisConfiguration model() {
        put("model", redisProperties.getModel());
        return this;
    }

    /**
     * 设置目标机器主机名和端口,集群模式逗号分隔
     */
    private RedisConfiguration hostPort() {
        put("hostAndPort", redisProperties.getHostAndPort());
        return this;
    }

    private RedisConfiguration timeOut() {
        put("timeOut", redisProperties.getTimeOut());
        return this;
    }

    public RedisConfiguration pass() {
        put("pass", redisProperties.getPass());
        return this;
    }

    /**
     * 集群最大转发数
     *
     * @return
     */
    private RedisConfiguration maxRedirections() {
        put("maxRedirections", redisProperties.getMaxRedirections());
        return this;
    }

    /**
     * 连接池最大空闲数
     *
     * @return
     */
    private RedisConfiguration maxIdle() {
        put("maxIdle", redisProperties.getMaxIdle());
        return this;
    }

    /**
     * 连接池最大连接数
     *
     * @return
     */
    private RedisConfiguration maxTotal() {
        put("maxTotal", redisProperties.getMaxTotal());
        return this;
    }

    /**
     * 连接池获取连接最大毫秒数
     *
     * @return
     */
    private RedisConfiguration maxWaitMillis() {
        put("maxWaitMillis", redisProperties.getMaxWaitMillis());
        return this;
    }

    public String getModel() {
        return redisProperties.getModel();
    }

    public void setModel(String model) {
        redisProperties.setModel(model);
    }

    public String getHostAndPort() {
        return redisProperties.getHostAndPort();
    }

    public void setHostAndPort(String hostAndPort) {
        redisProperties.setHostAndPort(hostAndPort);
    }

    public String getTimeOut() {
        return redisProperties.getTimeOut();
    }

    public void setTimeOut(String timeOut) {
        redisProperties.setTimeOut(timeOut);
    }

    public String getMaxRedirections() {
        return redisProperties.getMaxRedirections();
    }

    public void setMaxRedirections(String maxRedirections) {
        redisProperties.setMaxRedirections(maxRedirections);
    }

    public String getMaxIdle() {
        return redisProperties.getMaxIdle();
    }

    public void setMaxIdle(String maxIdle) {
        redisProperties.setMaxIdle(maxIdle);
    }

    public String getMaxTotal() {
        return redisProperties.getMaxTotal();
    }

    public void setMaxTotal(String maxTotal) {
        redisProperties.setMaxTotal(maxTotal);
    }

    public String getMaxWaitMillis() {
        return redisProperties.getMaxWaitMillis();
    }

    public void setMaxWaitMillis(String maxWaitMillis) {
        redisProperties.setMaxWaitMillis(maxWaitMillis);
    }

    public String getPass() {
        return redisProperties.getPass();
    }

    public void setPass(String pass) {
        redisProperties.setPass(pass);
    }
}
