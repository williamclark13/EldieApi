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
@RequestMapping(path = "/api/v1/help")
public class HelpRequestController {

	private HelpRequestStorage helpRequestStorage;

	public HelpRequestController(HelpRequestStorage helpRequestStorage) {
		this.helpRequestStorage = helpRequestStorage;
	}

	@PostMapping
	public HelpRequest createHelpRequest(@RequestBody HelpRequest helpRequestRequest) {
		String requesterName = helpRequestRequest.getRequesterName();
		String helpType = helpRequestRequest.getHelpType();
		return helpRequestStorage.createHelpRequest(requesterName, helpType);
	}

	@GetMapping
	public List<HelpRequest> getAllHelpRequests() {
		return helpRequestStorage.getAllHelpRequests();
	}

	@GetMapping("/{id}")
	public HelpRequest getHelpRequestById(@PathVariable Long id) {
		return helpRequestStorage.getHelpRequestById(id);
	}

	@PutMapping("/{id}/fulfilled")
	public void markHelpRequestFulfilled(@PathVariable Long id) {
		helpRequestStorage.markHelpRequestFulfilled(id);
	}
}
