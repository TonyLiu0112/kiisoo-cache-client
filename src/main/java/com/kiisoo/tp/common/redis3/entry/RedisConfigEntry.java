package com.kiisoo.tp.common.redis3.entry;

import java.util.Set;

import redis.clients.jedis.HostAndPort;

/**
 * redis配置实体
 * @author liuboyu
 *
 */
public class RedisConfigEntry {
	
	/**
	 * 集群服务节点字符串（解析前）
	 */
	private String clusterServices;
	
	/**
	 * 集群服务节点集合（解析后）
	 */
	private Set<HostAndPort> clusterNodes;
	
	/**
	 * 超时时间
	 */
	private int timeout;
	
	/**
	 * 最大重定向数
	 */
	private int maxRedirections;

	public String getClusterServices() {
		return clusterServices;
	}

	public void setClusterServices(String clusterServices) {
		this.clusterServices = clusterServices;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public int getMaxRedirections() {
		return maxRedirections;
	}

	public void setMaxRedirections(int maxRedirections) {
		this.maxRedirections = maxRedirections;
	}

	public Set<HostAndPort> getClusterNodes() {
		return clusterNodes;
	}

	public void setClusterNodes(Set<HostAndPort> clusterNodes) {
		this.clusterNodes = clusterNodes;
	}
	
}
