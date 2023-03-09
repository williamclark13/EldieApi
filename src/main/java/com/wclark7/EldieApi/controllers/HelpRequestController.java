package com.wclark7.EldieApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wclark7.EldieApi.models.HelpRequest;
import com.wclark7.EldieApi.storage.HelpRequestStorage;

@RestController
@RequestMapping("/api/v1/help")
class HelpRequestController {
	private HelpRequestStorage helpRequestStorage;

	/**
	 * Constructs a HelpRequestController with a HelpRequestStorage.
	 * 
	 * @param helpRequestStorage the HelpRequestStorage to use
	 */
	public HelpRequestController(HelpRequestStorage helpRequestStorage) {
		this.helpRequestStorage = helpRequestStorage;
	}

	/**
	 * Creates a new HelpRequest with the provided information.
	 * 
	 * @param helpRequest the HelpRequest to create
	 * @return the created HelpRequest
	 * @throws IllegalArgumentException if the provided HelpRequest is null or has
	 *                                  an ID already assigned
	 */
	@PostMapping("/request")
	public HelpRequest createHelpRequest(@RequestBody HelpRequest helpRequest) {
		if (helpRequest == null || helpRequest.getId() != null) {
			throw new IllegalArgumentException("Invalid HelpRequest");
		}
		String requesterName = helpRequest.getRequesterName();
		String helpType = helpRequest.getHelpType();
		return helpRequestStorage.createHelpRequest(requesterName, helpType);
	}

	/**
	 * Retrieves all HelpRequests.
	 * 
	 * @return a List of all HelpRequests
	 */
	@GetMapping("/all")
	public List<HelpRequest> getAllHelpRequests() {
		return helpRequestStorage.getAllHelpRequests();
	}

	/**
	 * Retrieves a HelpRequest by ID.
	 * 
	 * @param id the ID of the HelpRequest to retrieve
	 * @return the retrieved HelpRequest, or null if not found
	 */
	@GetMapping("/{id}")
	public HelpRequest getHelpRequestById(@PathVariable Long id) {
		return helpRequestStorage.getHelpRequestById(id);
	}

	/**
	 * Marks a HelpRequest as fulfilled.
	 * 
	 * @param id the ID of the HelpRequest to mark as fulfilled
	 * @throws IllegalArgumentException if the provided ID is null or invalid
	 */
	@PutMapping("/{id}/fulfilled")
	public void markHelpRequestFulfilled(@PathVariable Long id) {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("Invalid HelpRequest ID");
		}
		helpRequestStorage.markHelpRequestFulfilled(id);
	}
}