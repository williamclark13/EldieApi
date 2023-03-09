package com.wclark7.EldieApi.repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.wclark7.EldieApi.models.HelpRequest;

/**
 * A HelpRequestRepository manages the storage and retrieval of HelpRequest
 * objects.
 */
@Repository
public class HelpRequestRepository {
	private List<HelpRequest> helpRequests = new ArrayList<>();

	/**
	 * Returns a list of all HelpRequest objects.
	 *
	 * @return a list of all HelpRequest objects
	 */
	public List<HelpRequest> findAll() {
		return Collections.unmodifiableList(helpRequests);
	}

	/**
	 * Finds a HelpRequest object by its ID.
	 *
	 * @param id the ID of the HelpRequest object to find
	 * @return the HelpRequest object with the specified ID, or null if no such
	 *         object exists
	 */
	public HelpRequest findById(Long id) {
		for (HelpRequest helpRequest : helpRequests) {
			if (helpRequest.getId().equals(id)) {
				return helpRequest;
			}
		}
		return null;
	}

	/**
	 * Saves a HelpRequest object.
	 *
	 * @param helpRequest the HelpRequest object to save
	 * @return the saved HelpRequest object
	 */
	public HelpRequest save(HelpRequest helpRequest) {
		helpRequests.add(helpRequest);
		return helpRequest;
	}

	/**
	 * Deletes a HelpRequest object by its ID.
	 *
	 * @param id the ID of the HelpRequest object to delete
	 * @return true if the object was deleted, false if no such object exists
	 */
	public boolean deleteById(Long id) {
		HelpRequest helpRequestToRemove = null;
		for (HelpRequest helpRequest : helpRequests) {
			if (helpRequest.getId().equals(id)) {
				helpRequestToRemove = helpRequest;
				break;
			}
		}
		if (helpRequestToRemove != null) {
			helpRequests.remove(helpRequestToRemove);
			return true;
		}
		return false;
	}
}