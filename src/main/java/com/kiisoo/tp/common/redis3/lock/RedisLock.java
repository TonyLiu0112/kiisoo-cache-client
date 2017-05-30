package com.kiisoo.tp.common.redis3.lock;

import com.kiisoo.tp.common.redis3.LockCallBack;


/**
 * Redis 分布式锁
 * @author liuboyu
 *
 */
public class RedisLock extends RedisLockSuper {
	
	@Override
	public boolean tryLock(String lockName) {
		return tryLock(lockName, DEFAULT_RETRY_TIME);
	}
	
	@Override
	public void tryLockWithHold(String lockName) {
		tryLockWithHold(lockName, DEFAULT_RETRY_TIME, DEFAULT_TIME_OUT);
	}
	
	@Override
	public <T> T openLock(String lockName, long timeout, LockCallBack<T> callback) {
		T t = null;
		tryLock(lockName, timeout);
		
		if (!hasLock()) 
			return null;
		
		try {
			t = callback.callBack();
		} catch (Exception e) {
			throw new RuntimeException("redis lock do Service exception" + e);
		} finally {
			if (hasLock()) 
				releaseLock(lockName);
		}
		return t;
	}

}
