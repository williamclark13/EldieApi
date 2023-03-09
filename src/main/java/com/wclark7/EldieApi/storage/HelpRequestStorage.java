package com.wclark7.EldieApi.storage;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

import com.wclark7.EldieApi.models.HelpRequest;
import com.wclark7.EldieApi.repositories.HelpRequestRepository;

@Component
public class HelpRequestStorage {
	private HelpRequestRepository helpRequestRepository;

	/**
	 * Constructs a HelpRequestStorage with a HelpRequestRepository.
	 * 
	 * @param helpRequestRepository the HelpRequestRepository to use
	 */
	public HelpRequestStorage(HelpRequestRepository helpRequestRepository) {
		this.helpRequestRepository = helpRequestRepository;
	}

	/**
	 * Creates a new HelpRequest with the given requester name and help type.
	 * 
	 * @param requesterName the name of the requester
	 * @param helpType      the type of help requested
	 * @return the new HelpRequest object
	 * @throws IllegalArgumentException if either argument is null or empty
	 */
	public HelpRequest createHelpRequest(String requesterName, String helpType) {
		if (requesterName == null || requesterName.isEmpty()) {
			throw new IllegalArgumentException("Requester name cannot be null or empty");
		}
		if (helpType == null || helpType.isEmpty()) {
			throw new IllegalArgumentException("Help type cannot be null or empty");
		}

		Long id = getNextId();
		LocalDateTime requestedDateTime = LocalDateTime.now();
		HelpRequest helpRequest = new HelpRequest(id, requesterName, requestedDateTime, helpType);
		helpRequestRepository.save(helpRequest);
		return helpRequest;
	}

	/**
	 * Retrieves all HelpRequest objects.
	 * 
	 * @return a List of all HelpRequest objects
	 */
	public List<HelpRequest> getAllHelpRequests() {
		return helpRequestRepository.findAll();
	}

	/**
	 * Retrieves a HelpRequest object by ID.
	 * 
	 * @param id the ID of the HelpRequest to retrieve
	 * @return the HelpRequest object with the given ID, or null if not found
	 * @throws IllegalArgumentException if the ID is null or less than or equal to 0
	 */
	public HelpRequest getHelpRequestById(Long id) {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("ID cannot be null or less than or equal to 0");
		}

		return helpRequestRepository.findById(id);
	}

	/**
	 * Marks a HelpRequest as fulfilled by setting the fulfilledDateTime to the
	 * current time.
	 * 
	 * @param id the ID of the HelpRequest to mark as fulfilled
	 * @throws IllegalArgumentException if the ID is null or less than or equal to
	 *                                  0, or if the HelpRequest with the given ID
	 *                                  does not exist
	 */
	public void markHelpRequestFulfilled(Long id) {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("ID cannot be null or less than or equal to 0");
		}

		HelpRequest helpRequest = helpRequestRepository.findById(id);
		if (helpRequest == null) {
			throw new IllegalArgumentException("No HelpRequest found with ID " + id);
		}

		helpRequest.setFulfilledDateTime(LocalDateTime.now());
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