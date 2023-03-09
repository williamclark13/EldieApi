package com.wclark7.EldieApi.models;

import java.time.LocalDateTime;

/**
 * A HelpRequest represents a request for help made by a user.
 */
public class HelpRequest {
	private Long id;
	private String requesterName;
	private LocalDateTime requestedDateTime;
	private String helpType;
	private LocalDateTime fulfilledDateTime;

	/**
	 * Constructs a new HelpRequest object.
	 *
	 * @param id                the ID of the request
	 * @param requesterName     the name of the user making the request
	 * @param requestedDateTime the date and time when the request was made
	 * @param helpType          the type of help requested
	 */
	public HelpRequest(Long id, String requesterName, LocalDateTime requestedDateTime, String helpType) {
		this.setId(id);
		this.requesterName = requesterName;
		this.requestedDateTime = requestedDateTime;
		this.helpType = helpType;
	}

	/**
	 * Get RequestedDateTime
	 * 
	 * @return RequestedDateTime
	 */
	public LocalDateTime getRequestedDateTime() {
		return requestedDateTime;
	}

	/**
	 * Get HelpType
	 * 
	 * @return HelpType
	 */
	public String getHelpType() {
		return helpType;
	}

	/**
	 * Get FulfilledDateTime
	 * 
	 * @return FulfilledDateTime
	 */
	public LocalDateTime getFulfilledDateTime() {
		return fulfilledDateTime;
	}

	/**
	 * Sets the date and time when the request was fulfilled.
	 *
	 * @param fulfilledDateTime the date and time when the request was fulfilled
	 */
	public void setFulfilledDateTime(LocalDateTime fulfilledDateTime) {
		this.fulfilledDateTime = fulfilledDateTime;
	}

	/**
	 * Get Requester Name
	 * 
	 * @return requester name
	 */
	public String getRequesterName() {
		return requesterName;
	}

	/**
	 * Gets ID
	 * 
	 * @return id
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Sets ID
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
}