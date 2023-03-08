package com.wclark7.EldieApi.storage;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

import com.wclark7.EldieApi.models.HelpRequest;
import com.wclark7.EldieApi.repositories.HelpRequestRepository;

@Component
public class HelpRequestStorage {

	private HelpRequestRepository helpRequestRepository;

	public HelpRequestStorage(HelpRequestRepository helpRequestRepository) {
		this.helpRequestRepository = helpRequestRepository;
	}

	public HelpRequest createHelpRequest(String requesterName, String helpType) {
		Long id = getNextId();
		LocalDateTime requestedDateTime = LocalDateTime.now();
		HelpRequest helpRequest = new HelpRequest(id, requesterName, requestedDateTime, helpType);
		helpRequestRepository.save(helpRequest);
		return helpRequest;
	}

	public List<HelpRequest> getAllHelpRequests() {
		return helpRequestRepository.findAll();
	}

	public HelpRequest getHelpRequestById(Long id) {
		return helpRequestRepository.findById(id);
	}

	public void markHelpRequestFulfilled(Long id) {
		HelpRequest helpRequest = helpRequestRepository.findById(id);
		if (helpRequest != null) {
			helpRequest.setFulfilledDateTime(LocalDateTime.now());
		}
	}

	private Long getNextId() {
		List<HelpRequest> helpRequests = helpRequestRepository.findAll();
		Long maxId = 0L;
		for (HelpRequest helpRequest : helpRequests) {
			if (helpRequest.getId() > maxId) {
				maxId = helpRequest.getId();
			}
		}
		return maxId + 1;
	}

}
