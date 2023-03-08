package com.wclark7.EldieApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wclark7.EldieApi.models.HelpRequest;
import com.wclark7.EldieApi.services.HelpRequestService;

@RestController
@RequestMapping(path = "/api/v1/help")
public class HelpRequestController {

	private HelpRequestService helpRequestService;

	@Autowired
	public HelpRequestController(HelpRequestService helpRequestService) {
		this.helpRequestService = helpRequestService;
	}

	@PostMapping("/help-requests")
	public HelpRequest createHelpRequest(@RequestBody HelpRequest helpRequest) {
		return helpRequestService.createHelpRequest(helpRequest);
	}

	@PutMapping("/help-requests/{id}")
	public HelpRequest updateHelpRequest(@PathVariable Long id, @RequestBody HelpRequest helpRequest) {
		helpRequest.setId(id);
		return helpRequestService.updateHelpRequest(helpRequest);
	}

	@DeleteMapping("/help-requests/{id}")
	public void deleteHelpRequest(@PathVariable Long id) {
		helpRequestService.deleteHelpRequest(id);
	}

	@GetMapping("/help-requests/{id}")
	public HelpRequest getHelpRequestById(@PathVariable Long id) {
		return helpRequestService.getHelpRequestById(id);
	}

	@GetMapping("/help-requests")
	public List<HelpRequest> getAllHelpRequests() {
		return helpRequestService.getAllHelpRequests();
	}
}