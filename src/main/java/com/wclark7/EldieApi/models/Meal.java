package com.wclark7.EldieApi.models;

import java.util.List;

public class Meal {
	private String name;
	private List<String> combinations;

	public Meal(String name, List<String> combinations) {
		this.name = name;
		this.combinations = combinations;
	}

	public String getName() {
		return name;
	}

	public List<String> getCombinations() {
		return combinations;
	}
}