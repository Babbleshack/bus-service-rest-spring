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
		return busStopRepository.findAll();
	}

	@Override
	public BusStop findOne(String id) {
		return busStopRepository.findOne(id);
	}

	@Override
	public String create(BusStop busStop) {
		return busStopRepository.create(busStop);
	}

	@Override
	public BusStop delete(String id) {
		return busStopRepository.delete(id);
	}

	@Override
	public BusStop update(BusStop busStop) {
		return busStopRepository.update(busStop);
	}

}
