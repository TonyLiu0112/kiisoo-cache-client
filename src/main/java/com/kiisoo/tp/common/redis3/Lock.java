package com.kiisoo.tp.common.redis3;


/**
 * 抽象锁
 * 
 * @author liuboyu
 * @Apr 14, 2015 10:52:41 PM
 */
public interface Lock {
	
	public static final long DEFAULT_RETRY_TIME = 1000;
	public static final long DEFAULT_TIME_OUT = 60000;

	final String LOCKED = "locked";

	/**
	 * 尝试获得锁，立即返回
	 * <p>
	 * 锁默认持续时间5分钟
	 * 
	 * @param lockName
	 */
	public boolean tryLock(String lockName);

	/**
	 * 尝试获取锁，立即返回
	 * 
	 * @param lockName
	 * @param timeout
	 *            锁的超时时间
	 */
	public boolean tryLock(String lockName, long timeout);

	/**
	 * 尝试获得锁，未获得锁则不断重试获取锁,直到获得锁为止
	 * <p>
	 * 
	 * 默认重试获取时间为1000毫秒<br>
	 * 锁默认持续时间5分钟<br>
	 * 
	 * @param lockName
	 */
	public void tryLockWithHold(String lockName);

	/**
	 * 尝试获得锁，未获得不断重试获取锁,直到获得锁为止
	 * 
	 * @param lockName
	 * @param retryTime
	 *            每次重试获取锁的时间-毫秒
	 * @param timeout
	 *            锁的超时时间
	 */
	public void tryLockWithHold(String lockName, long retryTime, long timeout);
	
	/**
	 * 尝试获得锁，未获得不断重试获取锁,知道时间范围结束
	 * 
	 * @param lockName
	 * @param retryTime
	 * @param timeout
	 * @param spanTime
	 */
	public void tryLockWithHoldSpan(String lockName, long retryTime, long timeout, long spanTime);

	/**
	 * 释放锁
	 * 
	 * @param path
	 */
	public void releaseLock(String lockName);

	/**
	 * 是否持有锁
	 * 
	 * @return
	 */
	public boolean hasLock();

	/**
	 * 封装锁的控制权 由Lock来完成开启锁 释放锁的动作 此锁获得之后立即返回 调用者只需关心业务逻辑代码
	 * 请处理好代码异常，否则Lock对象将抛出一个RuntimeException
	 * 
	 * @param lockName
	 * @param timeout
	 *            锁的持续时间，在指定时间后超时
	 * @param callback
	 *            回调函数
	 * @return
	 */
	<T> T openLock(String lockName, long timeout, LockCallBack<T> callback);

}
