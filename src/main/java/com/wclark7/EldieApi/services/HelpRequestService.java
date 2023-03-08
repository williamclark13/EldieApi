package com.wclark7.EldieApi.services;

import java.util.List;

import com.wclark7.EldieApi.models.HelpRequest;
import com.wclark7.EldieApi.storage.HelpRequestStorage;

public class HelpRequestService {

	private HelpRequestStorage helpRequestStorage;

	public HelpRequestService(HelpRequestStorage helpRequestStorage) {
		this.helpRequestStorage = helpRequestStorage;
	}

	public HelpRequest createHelpRequest(HelpRequest helpRequest) {
		helpRequestStorage.save(helpRequest);
		return helpRequest;
	}

	public HelpRequest updateHelpRequest(HelpRequest helpRequest) {
		helpRequestStorage.update(helpRequest);
		return helpRequest;
	}

	public void deleteHelpRequest(Long id) {
		HelpRequest helpRequest = helpRequestStorage.findById(id);
		if (helpRequest != null) {
			helpRequestStorage.delete(helpRequest);
		}
	}

	public HelpRequest getHelpRequestById(Long id) {
		return helpRequestStorage.findById(id);
	}

	public List<HelpRequest> getAllHelpRequests() {
		return helpRequestStorage.findAll();
	}
}
