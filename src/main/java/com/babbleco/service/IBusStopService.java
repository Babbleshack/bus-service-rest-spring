package com.babbleco.service;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import com.babbleco.model.BusStop;

public interface IBusStopService {
	/**
	 * Find a BusStop
	 * @param id - the id of the BusStop.
	 * @return A BusStop object or null if not found.
	 */
	BusStop findOne(String id);
	/**
	 * Find all BusStopses.
	 * @return - a list of all BusStopses
	 */
	List<BusStop> findAll();
	/**
	 * Persist a BusStop object.
	 * @param BusStop - The BusStop object to be persisted.
	 * @return - the id of the persisted BusStop object.
	 */
	String create(BusStop busStop);
	/**
	 * Delete a BusStop service from persistence.
	 * @param id - the id of the BusStop to be removed from persistence storage.
	 * @return - the removed BusStop.
	 */ 
	BusStop delete(String id);
	/**
	 * Update the a BusStop service at the persistence storage.
	 * @param BusStop - the BusStop object.
	 * @return - the update BusStop object.
	 */
	BusStop update(BusStop busStop);
}
