package com.stemcell.redis3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kiisoo.tp.common.redis3.RedisClient;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.Protocol;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/test-spring-context.xml" })
public class JunitTest3 extends AbstractJUnit4SpringContextTests {
	
	
	@Before
	public void before() {
		System.out.println("* * * * * * * * * * start testing * * * * * * * * * * ");
	}
	
	@After
	public void after() {
		System.out.println("* * * * * * * * * * end testing * * * * * * * * * * ");
	}
	
	@Test
	public void listTest() {

	}
	
	@Test
	public void test() {
//		final CountDownLatch latch = new CountDownLatch(3);
//		for (int i = 0; i < 3; i ++) {
//			final int index = i;
//			new Thread(new Runnable() {
//
//				int x = index;
//				int count = 0;
//
//				@Override
//				public void run() {
//					try {
//						latch.await();
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//
//					if (!RedisClient.exists("thread"+x)) {
//						RedisClient.set("thread"+x, "thread"+x);
//					}
//
//					for (int i = 0; i < 10000; i ++) {
//
//						if (RedisClient.get("thread"+x).equals("thread"+x)) {
//							count ++;
//							RedisClient.set("thread"+x, "thread"+x);
//							System.out.println(Thread.currentThread().getName());
//						} else {
//							System.out.println(("thread"+x) + " >> " + count);
//						}
//					}
//
//					System.out.println(("thread"+x) + " >> " + RedisClient.get("thread"+x) + " >> "+ count);
//
//				}
//
//			}).start();
//			latch.countDown();
//		}
//		try {
//			Thread.currentThread().sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//        RedisClient.set("大师", "aas");
//        System.out.println(RedisClient.get("大师"));
		JedisShardInfo jedisShardInfo = new JedisShardInfo("139.129.219.189", 6379);
		jedisShardInfo.setPassword("bxrds008");
		Jedis jedis = new Jedis(jedisShardInfo);
		jedis.set("tony", "bb");
		System.out.println(jedis.get("tony"));

		JedisPool jedisPool = new JedisPool(new GenericObjectPoolConfig(), "139.129.219.189", 6379, Protocol.DEFAULT_TIMEOUT, "bxrds008",
				Protocol.DEFAULT_DATABASE, null);
		jedisPool.getResource().set("tony", "aa");
		System.out.println(jedisPool.getResource().get("tony"));
	}
	
}
