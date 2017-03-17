package com.babbleco.service;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import com.babbleco.model.Bus;

public interface IBusService {
	/**
	 * Find a bus
	 * @param id - the id of the bus.
	 * @return A bus object or null if not found.
	 */
	Bus findOne(String id);
	/**
	 * Find all busses.
	 * @return - a list of all busses
	 */
	List<Bus> findAll();
	/**
	 * Persist a bus object.
	 * @param bus - The bus object to be persisted.
	 * @return - the id of the persisted bus object.
	 */
	String create(Bus bus);
	/**
	 * Delete a bus service from persistence.
	 * @param id - the id of the bus to be removed from persistence storage.
	 * @return - the removed bus.
	 */ 
	Bus delete(String id);
	/**
	 * Update the a bus service at the persistence storage.
	 * @param bus - the bus object.
	 * @return - the update bus object.
	 */
	Bus update(Bus bus);
	
	/**
	 * @return - a list of all deleted bus services.
	 */
	List<Bus> deleteAll();

}
