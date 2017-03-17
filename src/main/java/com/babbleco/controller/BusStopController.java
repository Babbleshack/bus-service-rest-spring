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

import com.babbleco.model.BusStop;
import com.babbleco.service.IBusStopService;

@RestController
@RequestMapping(value="/busStop")
public class BusStopController {
	@Autowired
	private IBusStopService busStopService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<BusStop>> findAll() 
	{
		List<BusStop> busStopses = busStopService.findAll();
		if(busStopses.isEmpty())
		{
			return new ResponseEntity<List<BusStop>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<BusStop>>(busStopses, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<BusStop> findOne(@PathVariable String id)
	{
		System.out.println("Calling findOne with id: " + id);
		BusStop BusStop = busStopService.findOne(id);
		if(BusStop == null)
		{
			return new ResponseEntity<BusStop>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<BusStop>(BusStop, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> create(@RequestBody BusStop BusStop) 
	{
		String id = busStopService.create(BusStop);
		if(StringUtils.isEmpty(id))
		{
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<String>(id, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<BusStop> update(@PathVariable String id, @RequestBody BusStop BusStop)
	{
		BusStop updatedBusStop = busStopService.update(BusStop);
		if(updatedBusStop == null)
		{
			return new ResponseEntity<BusStop>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<BusStop>(updatedBusStop, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<BusStop> delete(@PathVariable String id)
	{
		BusStop busStop = busStopService.delete(id);
		if(busStop == null)
		{
			return new ResponseEntity<BusStop>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<BusStop>(busStop, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public ResponseEntity<List<BusStop>> deleteAll()
	{
		List<BusStop> busStopList = busStopService.deleteAll();
		if(busStopList.isEmpty())
		{
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<List<BusStop>>(busStopList, HttpStatus.OK);
	}
	
}
