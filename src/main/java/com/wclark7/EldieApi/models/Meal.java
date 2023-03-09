package com.wclark7.EldieApi.models;

import java.util.List;

public class Meal {
	private String name;
	private List<String> combinations;

	/**
	 * Constructs a Meal with a name and list of combinations.
	 *
	 * @param name         the name of the meal
	 * @param combinations the list of combinations for the meal
	 */
	public Meal(String name, List<String> combinations) {
		this.name = name;
		this.combinations = combinations;
	}

	/**
	 * Gets the name of the meal.
	 *
	 * @return the name of the meal
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the list of combinations for the meal.
	 *
	 * @return the list of combinations for the meal
	 */
	public List<String> getCombinations() {
		return combinations;
	}
}