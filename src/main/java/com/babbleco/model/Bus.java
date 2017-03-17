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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Bus)) {
			return false;
		}
		Bus other = (Bus) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}
	
	

}
