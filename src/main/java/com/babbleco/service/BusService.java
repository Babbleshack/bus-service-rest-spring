package com.babbleco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babbleco.model.Bus;
import com.babbleco.repository.IBusRepository;

@Service("busService")
public class BusService implements IBusService {
	//TODO: create autowired setter.
	@Autowired
	private IBusRepository busRepository;
 
	public void setBusRepository(IBusRepository busRepository) {
		this.busRepository = busRepository;
	}

	@Override
	public List<Bus> findAll() {
		return busRepository.findAll();
	}

	@Override
	public Bus findOne(String id) {
		return busRepository.findOne(id);
	}

	@Override
	public String create(Bus bus) {
		return busRepository.create(bus);
	}

	@Override
	public Bus delete(String id) {
		return busRepository.delete(id);
	}

	@Override
	public Bus update(Bus bus) {
		return busRepository.update(bus);
	}

	@Override
	public List<Bus> deleteAll() {
		return busRepository.deleteAll();
	}

}
