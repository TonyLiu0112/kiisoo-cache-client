package com.kiisoo.tp.common.redis3.lock;

import com.kiisoo.tp.common.redis3.Lock;
import com.kiisoo.tp.common.redis3.RedisClient;

/**
 * RedisLockSuper
 * 
 * @author liuboyu
 * @Apr 17, 2015 5:16:34 PM
 */
public abstract class RedisLockSuper implements Lock {

	private boolean hasLock = false;
	private Object retryLock = new Object();

	@Override
	public boolean tryLock(String lockName, long timeout) {
		long tryLock = RedisClient.setnx(lockName, LOCKED);
		if (tryLock > 0) {
			hasLock = true;
			RedisClient.pexpire(lockName, timeout);
		}
		return hasLock;
	}

	@Override
	public void tryLockWithHold(String lockName, long retryTime, long timeout) {
		while (true) {
			if (hasLock) 
				break;
			getHoldLock(lockName, retryTime, timeout);
		}
	}

	public void tryLockWithHoldSpan(String lockName, long retryTime, long timeout, long spanTime) {
		long startTime = System.currentTimeMillis();
		while (System.currentTimeMillis() - startTime <= spanTime) {
			if (hasLock) 
				break;
			getHoldLock(lockName, retryTime, timeout);
		}
	}
	
	private void getHoldLock(String lockName, long retryTime, long timeout) {
		long tryLock = RedisClient.setnx(lockName, LOCKED);
		if (tryLock > 0) {
			hasLock = true;
			RedisClient.pexpire(lockName, timeout);
		}
		synchronized (retryLock) {
			try {
				retryLock.wait(retryTime);
			} catch (InterruptedException e) {
			}
		}
	}

	@Override
	public void releaseLock(String lockName) {
		if (hasLock)
			RedisClient.del(lockName);
	}

	@Override
	public boolean hasLock() {
		return hasLock;
	}

}
