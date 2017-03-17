package com.babbleco.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.babbleco.model.BusStop;

@Repository("busStopRepository")
public class BusStopRepositoryStub implements IBusStopRepository {

	Map<String, BusStop> busStopMap = new HashMap<>();

	public BusStopRepositoryStub() {
		for (int i = 0; i < 10; i++) {
			BusStop stop = IBusStopRepository.generateBusStop();
			busStopMap.put(stop.getId(), stop);
		}
	}

	@Override
	public BusStop findOne(String id) {
		if (!busStopMap.containsKey(id)) {
			return null;
		}
		return busStopMap.get(id);
	}

	@Override
	public List<BusStop> findAll() {
		return busStopMap.values().stream().collect(Collectors.toList());
	}

	@Override
	public String create(BusStop BusStop) {
		if (!StringUtils.isEmpty(BusStop.getId()) || busStopMap.containsKey(BusStop.getId())) {
			// BusStop has id and is already mapped.
			return null;
		}
		String id = RandomStringUtils.randomAlphanumeric(6);
		BusStop.setId(id);
		busStopMap.put(BusStop.getId(), BusStop);
		return BusStop.getId();
	}

	@Override
	public BusStop delete(String id) {
		if (StringUtils.isEmpty(id) || !busStopMap.containsKey(id)) {
			// id was null or BusStop was not found
			return null;
		}
		return busStopMap.remove(id);
	}

	@Override
	public BusStop update(BusStop BusStop) {
		if (StringUtils.isEmpty(BusStop.getId()) || !busStopMap.containsKey(BusStop.getId())) {
			// id was null or BusStop was not found
			return null;
		}
		busStopMap.put(BusStop.getId(), BusStop);
		return BusStop;
	}
}
