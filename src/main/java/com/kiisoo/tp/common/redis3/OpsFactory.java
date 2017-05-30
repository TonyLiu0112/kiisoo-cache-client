package com.kiisoo.tp.common.redis3;

import java.util.Map;

/**
 * 操作工厂类
 * <p>
 * 
 * @author Tony
 * @date Dec 12, 2015
 */
public abstract class OpsFactory {

	public enum MODEL {
		single, pool, cluster
	}

	public Ops handler(Map<String, String> confMap) {
		if (MODEL.single.toString().equals(confMap.get("model")))
			return createSingle(confMap);
		else if (MODEL.pool.toString().equals(confMap.get("model")))
			return createPool(confMap);
		else if (MODEL.cluster.toString().equals(confMap.get("model"))) 
			return createCluster(confMap);
		else
			throw new IllegalArgumentException("unkonw redis model.");
	}

	/**
	 * 生成单机操作对象
	 * <p>
	 * 
	 * @param confMap
	 * @return
	 */
	public abstract Ops createSingle(Map<String, String> confMap);

	/**
	 * 生成连接池操作对象
	 * <p>
	 * 
	 * @param confMap
	 * @return
	 */
	public abstract Ops createPool(Map<String, String> confMap);

	/**
	 * 生成集群操作对象
	 * <p>
	 * 
	 * @param confMap
	 * @return
	 */
	public abstract Ops createCluster(Map<String, String> confMap);

}
