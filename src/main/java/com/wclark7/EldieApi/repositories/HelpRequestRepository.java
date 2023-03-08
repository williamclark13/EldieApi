package com.wclark7.EldieApi.repositories;

import java.util.ArrayList;
import java.util.List;

import com.wclark7.EldieApi.models.HelpRequest;

public class HelpRequestRepository {

	private List<HelpRequest> helpRequests = new ArrayList<>();

	public List<HelpRequest> findAll() {
		return helpRequests;
	}

	public HelpRequest findById(Long id) {
		for (HelpRequest helpRequest : helpRequests) {
			if (helpRequest.getId().equals(id)) {
				return helpRequest;
			}
		}
		return null;
	}

	public HelpRequest save(HelpRequest helpRequest) {
		helpRequests.add(helpRequest);
		return helpRequest;
	}

	public void deleteById(Long id) {
		HelpRequest helpRequestToRemove = null;
		for (HelpRequest helpRequest : helpRequests) {
			if (helpRequest.getId().equals(id)) {
				helpRequestToRemove = helpRequest;
				break;
			}
		}
		if (helpRequestToRemove != null) {
			helpRequests.remove(helpRequestToRemove);
		}
	}

}
