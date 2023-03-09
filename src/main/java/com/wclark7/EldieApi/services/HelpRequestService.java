package com.wclark7.EldieApi.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wclark7.EldieApi.models.HelpRequest;
import com.wclark7.EldieApi.repositories.HelpRequestRepository;

/**
 * Service class for managing HelpRequests.
 */
@Service
public class HelpRequestService {
	private final HelpRequestRepository helpRequestRepository;

	/**
	 * Constructs a HelpRequestService with a HelpRequestRepository.
	 * 
	 * @param helpRequestRepository the HelpRequestRepository to use
	 */
	public HelpRequestService(HelpRequestRepository helpRequestRepository) {
		this.helpRequestRepository = helpRequestRepository;
	}

	/**
	 * Returns a list of all HelpRequests.
	 * 
	 * @return a list of HelpRequests
	 */
	public List<HelpRequest> getAllHelpRequests() {
		return helpRequestRepository.findAll();
	}

	/**
	 * Returns a HelpRequest with the specified id.
	 * 
	 * @param id the id of the HelpRequest to retrieve
	 * @return the HelpRequest with the specified id, or null if no such HelpRequest
	 *         exists
	 */
	public HelpRequest getHelpRequestById(Long id) {
		if (id == null) {
			throw new IllegalArgumentException("id cannot be null");
		}
		return helpRequestRepository.findById(id);
	}

	/**
	 * Adds a new HelpRequest to the repository.
	 * 
	 * @param helpRequest the HelpRequest to add
	 */
	public void addHelpRequest(HelpRequest helpRequest) {
		if (helpRequest == null) {
			throw new IllegalArgumentException("helpRequest cannot be null");
		}
		helpRequestRepository.save(helpRequest);
	}

	/**
	 * Marks the HelpRequest with the specified id as fulfilled.
	 * 
	 * @param id the id of the HelpRequest to mark as fulfilled
	 */
	public void fulfillHelpRequest(Long id) {
		if (id == null) {
			throw new IllegalArgumentException("id cannot be null");
		}
		HelpRequest helpRequest = helpRequestRepository.findById(id);
		if (helpRequest != null) {
			helpRequest.setFulfilledDateTime(LocalDateTime.now());
			helpRequestRepository.save(helpRequest);
		} else {
			throw new IllegalArgumentException("No HelpRequest with id " + id + " exists");
		}
	}
}