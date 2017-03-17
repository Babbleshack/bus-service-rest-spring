package com.babbleco.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.babbleco.model.Bus;

@Repository("busRepository")
public class BusRepositoryStub implements IBusRepository {
	
	Map<String, Bus> busMap = new HashMap<>();
	
	public BusRepositoryStub() {
		for(int i=0; i<10; i++)
		{
			Bus bus = IBusRepository.generateBus();
			busMap.put(bus.getId(), bus);
		}
	}
	
	@Override
	public Bus findOne(String id) {
		if(!busMap.containsKey(id))
		{
			return null;
		}
		return busMap.get(id);
	}

	@Override
	public List<Bus> findAll() {
		return busMap.values().stream().collect(Collectors.toList());
	}

	@Override
	public String create(Bus bus) {
		if(!StringUtils.isEmpty(bus.getId()) || busMap.containsKey(bus.getId()))
		{
			//bus has id and is already mapped.
			return null; 
		}
		String id = RandomStringUtils.randomAlphanumeric(6);
		bus.setId(id);
		busMap.put(bus.getId(), bus);
		return bus.getId();
	}

	@Override
	public Bus delete(String id) {
		if(StringUtils.isEmpty(id) || !busMap.containsKey(id))
		{
			// id was null or bus was not found
			return null;
		}
		return busMap.remove(id);
	}

	@Override
	public Bus update(Bus bus) {
		if(StringUtils.isEmpty(bus.getId()) || !busMap.containsKey(bus.getId()))
		{
			// id was null or bus was not found
			return null;
		}
		busMap.put(bus.getId(), bus);
		return bus;
	}

}
