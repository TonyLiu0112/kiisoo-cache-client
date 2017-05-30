package com.kiisoo.tp.common.redis3;

import com.kiisoo.tp.common.redis3.conf.RedisConfiguration;
import com.kiisoo.tp.common.redis3.factory.OpsInstanceFactory;

import java.io.IOException;

/**
 * @author Tony
 * @date Dec 12, 2015
 */
public class BaseRedis extends SuperCycle {

    private Ops ops;
    private OpsFactory factory;
    private RedisConfiguration conf;

    public BaseRedis() {
    }

    public BaseRedis(RedisConfiguration configuration) {
        this.conf = configuration;
    }

    @Override
    public void doInit() {
        factory = new OpsInstanceFactory();
        if (conf == null) {
            conf = new RedisConfiguration();
        }
        conf.doBind();
    }

    @Override
    public void doStart() {
        ops = factory.handler(conf);
        RedisClient.setOps(ops);
    }

    @Override
    public void doDestroy() {
        try {
            ops.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
