package com.babbleco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babbleco.model.BusStop;
import com.babbleco.repository.IBusStopRepository;

@Service("busStopService")
public class BusStopService implements IBusStopService {
	@Autowired
	IBusStopRepository busStopRepository;

	public void setBusStopRepository(IBusStopRepository busStopRepository) {
		this.busStopRepository = busStopRepository;
	}

	@Override
	public List<BusStop> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BusStop findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String create(BusStop busStop) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BusStop delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BusStop update(BusStop busStop) {
		// TODO Auto-generated method stub
		return null;
	}

}
