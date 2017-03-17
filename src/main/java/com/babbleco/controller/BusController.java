package com.babbleco.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.babbleco.model.Bus;
import com.babbleco.service.IBusService;

@RestController
@RequestMapping(value="/bus")
public class BusController {
	@Autowired
	private IBusService busService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Bus>> findAll() 
	{
		List<Bus> busses = busService.findAll();
		if(busses.isEmpty())
		{
			return new ResponseEntity<List<Bus>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Bus>>(busses, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Bus> findOne(@PathVariable String id)
	{
		System.out.println("Calling findOne with id: " + id);
		Bus bus = busService.findOne(id);
		if(bus == null)
		{
			return new ResponseEntity<Bus>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Bus>(bus, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> create(@RequestBody Bus bus) 
	{
		String id = busService.create(bus);
		if(StringUtils.isEmpty(id))
		{
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<String>(id, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Bus> update(@PathVariable String id, @RequestBody Bus bus)
	{
		Bus updatedBus = busService.update(bus);
		if(updatedBus == null)
		{
			return new ResponseEntity<Bus>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Bus>(updatedBus, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Bus> delete(@PathVariable String id)
	{
		Bus bus = busService.delete(id);
		if(bus == null)
		{
			return new ResponseEntity<Bus>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Bus>(bus, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public ResponseEntity<List<Bus>> deleteAll()
	{
		List<Bus> busList = busService.deleteAll();
		if(busList.isEmpty())
		{
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<List<Bus>>(busList, HttpStatus.OK);
	}
	
}
