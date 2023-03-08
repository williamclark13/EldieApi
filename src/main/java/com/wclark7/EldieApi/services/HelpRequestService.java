package com.wclark7.EldieApi.services;

import java.time.LocalDateTime;
import java.util.List;

import com.wclark7.EldieApi.models.HelpRequest;
import com.wclark7.EldieApi.repositories.HelpRequestRepository;

public class HelpRequestService {
	private final HelpRequestRepository helpRequestRepository;

	public HelpRequestService(HelpRequestRepository helpRequestRepository) {
		this.helpRequestRepository = helpRequestRepository;
	}

	public List<HelpRequest> getAllHelpRequests() {
		return helpRequestRepository.findAll();
	}

	public HelpRequest getHelpRequestById(Long id) {
		return helpRequestRepository.findById(id);
	}

	public void addHelpRequest(HelpRequest helpRequest) {
		helpRequestRepository.save(helpRequest);
	}

	public void fulfillHelpRequest(Long id) {
		HelpRequest helpRequest = helpRequestRepository.findById(id);
		if (helpRequest != null) {
			helpRequest.setFulfilledDateTime(LocalDateTime.now());
			helpRequestRepository.save(helpRequest);
		}
	}
}
