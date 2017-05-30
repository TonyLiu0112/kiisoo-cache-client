package com.kiisoo.tp.common.redis3;

/**
 * life cycle
 * @author liuboyu
 *
 */
public interface LifeCycle {
	
	void init();
	
	void start();
	
	void destroy();
	
}
