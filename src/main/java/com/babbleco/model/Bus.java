package com.babbleco.model;

import java.util.List;

/**
 * @author lindsay_dc A bus is a road vehicle which carries many people, and
 *         makes stop at multiple 'BusStops'
 */
public class Bus {

	List<String> busStops;
	private String id;
	String serviceId;

	/**
	 * @return list of bus stop id's.
	 */
	public List<String> getBusStops() {
		return busStops;
	}

	public String getId() {
		return id;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setBusStops(List<String> busStops) {
		this.busStops = busStops;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	@Override
	public String toString() {
		return "Bus [busStops=" + busStops + ", id=" + id + ", serviceId=" + serviceId + "]";
	}

}
