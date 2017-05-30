package com.kiisoo.tp.common.redis3;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * support 
 * @author liuboyu
 *
 */
public abstract class SuperCycle implements LifeCycle {
	
	private AtomicBoolean isInited = new AtomicBoolean(false);
	
	@Override
	public void init() {
		if (!isInited.getAndSet(true))
			doInit();
		start();
	}
	
	@Override
	public void start() {
		if (!isInited.get()) 
			init();
		else
            doStart();
	}
	
	@Override
	public void destroy() {
		doDestroy();
	}
	
	public abstract void doInit();
	
	public abstract void doStart();
	
	public abstract void doDestroy();
	
}
