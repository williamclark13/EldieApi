package com.wclark7.EldieApi.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.wclark7.EldieApi.models.HelpRequest;

public class HelpRequestRepository {

	private final List<HelpRequest> helpRequests = new ArrayList<>();
	private long nextId = 1;

	public Optional<HelpRequest> findById(long id) {
		return helpRequests.stream().filter(hr -> hr.getId() == id).findFirst();
	}

	public List<HelpRequest> findAll() {
		return new ArrayList<>(helpRequests);
	}

	public void save(HelpRequest helpRequest) {
		if (helpRequest.getId() == null) {
			helpRequest.setId(nextId++);
		}
		helpRequests.add(helpRequest);
	}

	public void update(HelpRequest helpRequest) {
		int index = helpRequests.indexOf(helpRequest);
		if (index != -1) {
			helpRequests.set(index, helpRequest);
		}
	}

	public void delete(HelpRequest helpRequest) {
		helpRequests.remove(helpRequest);
	}
}
