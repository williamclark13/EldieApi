package com.wclark7.EldieApi.storage;

import java.util.Arrays;
import java.util.List;

import com.wclark7.EldieApi.models.Meal;

public class MealStorage {

	private List<Meal> meals = Arrays.asList(
			new Meal("breakfast",
					Arrays.asList("sausage, grit, tea, toast", "sausage, toast, coffee, scrambled eggs",
							"sunny side up eggs, toast, water")),
			new Meal("lunch",
					Arrays.asList("turkey sandwich, potato chips, soda", "caesar salad, iced tea",
							"grilled chicken wrap, fries, lemonade")),
			new Meal("dinner", Arrays.asList("spaghetti and meatballs, red wine",
					"filet mignon, baked potato, green beans, beer", "grilled salmon, rice pilaf, white wine")));

	public List<Meal> getAllMeals() {
		return meals;
	}

}
