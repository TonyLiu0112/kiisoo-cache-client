package com.kiisoo.tp.common.redis3.lock;

import com.kiisoo.tp.common.redis3.Lock;

/**
 * Factory
 * @author liuboyu
 * @Apr 20, 2015 10:49:48 AM
 */
public class LockFactory {
	
	/**
	 * get a lock
	 * @return
	 */
	public static Lock getLock() {
		return new RedisLock();
	}
}
