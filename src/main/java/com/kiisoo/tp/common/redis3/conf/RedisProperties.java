package com.kiisoo.tp.common.redis3.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * redis基础配置项
 * Created by Tony on 22/03/2017.
 */
@ConfigurationProperties(prefix = "redis")
public class RedisProperties {

    private String model = "single";
    private String hostAndPort = "127.0.0.1:6379";
    private String pass = "foobared";
    private String timeOut = "2000";
    private String maxRedirections = "5";
    private String maxIdle = "8";
    private String maxTotal = "8";
    private String maxWaitMillis = "-1";

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getHostAndPort() {
        return hostAndPort;
    }

    public void setHostAndPort(String hostAndPort) {
        this.hostAndPort = hostAndPort;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    public String getMaxRedirections() {
        return maxRedirections;
    }

    public void setMaxRedirections(String maxRedirections) {
        this.maxRedirections = maxRedirections;
    }

    public String getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(String maxIdle) {
        this.maxIdle = maxIdle;
    }

    public String getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(String maxTotal) {
        this.maxTotal = maxTotal;
    }

    public String getMaxWaitMillis() {
        return maxWaitMillis;
    }

    public void setMaxWaitMillis(String maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }

    @Override
    public String toString() {
        return model;
    }
}
