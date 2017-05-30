package com.kiisoo.tp.common.redis3.factory;

import java.util.Map;

import com.kiisoo.tp.common.redis3.Ops;
import com.kiisoo.tp.common.redis3.OpsFactory;
import com.kiisoo.tp.common.redis3.core.ClusterOps;
import com.kiisoo.tp.common.redis3.core.PoolOps;
import com.kiisoo.tp.common.redis3.core.SingleOps;

/**
 * redis解析器
 * 
 * @author Tony
 * @date Dec 12, 2015
 */
public class OpsInstanceFactory extends OpsFactory {
	
	@Override
	public Ops createSingle(Map<String, String> confMap) {
		return new SingleOps(confMap);
	}

	@Override
	public Ops createPool(Map<String, String> confMap) {
		return new PoolOps(confMap);
	}

	@Override
	public Ops createCluster(Map<String, String> confMap) {
		return new ClusterOps(confMap);
	}

}
