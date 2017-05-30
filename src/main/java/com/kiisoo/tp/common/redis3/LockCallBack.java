package com.kiisoo.tp.common.redis3;

/**
 * 锁的回调
 * @author liuboyu
 * @Apr 18, 2015 3:29:52 PM
 */
public interface LockCallBack<T> {
	
	/**
	 * 回调方法
	 * @param t
	 * @return
	 */
	T callBack();
	
}
