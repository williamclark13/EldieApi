package com.wclark7.EldieApi.storage;

import java.util.ArrayList;
import java.util.List;

import com.wclark7.EldieApi.models.HelpRequest;

public class HelpRequestStorage {

	private List<HelpRequest> helpRequests = new ArrayList<>();
	private Long nextId = 1L;

	public HelpRequest findById(Long id) {
		return helpRequests.stream().filter(helpRequest -> helpRequest.getId().equals(id)).findFirst().orElse(null);
	}

	public List<HelpRequest> findAll() {
		return helpRequests;
	}

	public void save(HelpRequest helpRequest) {
		helpRequest.setId(nextId++);
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