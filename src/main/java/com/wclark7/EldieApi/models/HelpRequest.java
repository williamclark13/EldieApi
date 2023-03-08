package com.wclark7.EldieApi.models;

import java.time.LocalDateTime;

public class HelpRequest {
	private Long id;
	private String requesterName;
	private LocalDateTime requestedDateTime;
	private String helpType;
	private LocalDateTime fulfilledDateTime;

	public HelpRequest(Long id, String requesterName, LocalDateTime requestedDateTime, String helpType) {
		this.setId(id);
		this.requesterName = requesterName;
		this.requestedDateTime = requestedDateTime;
		this.helpType = helpType;
	}

	public String getRequesterName() {
		return requesterName;
	}

	public LocalDateTime getRequestedDateTime() {
		return requestedDateTime;
	}

	public String getHelpType() {
		return helpType;
	}

	public LocalDateTime getFulfilledDateTime() {
		return fulfilledDateTime;
	}

	public void setFulfilledDateTime(LocalDateTime fulfilledDateTime) {
		this.fulfilledDateTime = fulfilledDateTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
