package com.babbleco.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	//GET bus/id
	//
}
