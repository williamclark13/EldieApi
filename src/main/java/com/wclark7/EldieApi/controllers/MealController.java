package com.wclark7.EldieApi.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wclark7.EldieApi.models.Meal;

@RestController
@RequestMapping(path = "/api/v1/meal")
public class MealController {

	private List<Meal> meals = Arrays.asList(
			new Meal("breakfast",
					Arrays.asList("sausage, grit, tea, toast", "sausage, toast, coffee, scrambled eggs",
							"sunny side up eggs, toast, water")),
			new Meal("lunch",
					Arrays.asList("turkey sandwich, potato chips, soda", "caesar salad, iced tea",
							"grilled chicken wrap, fries, lemonade")),
			new Meal("dinner", Arrays.asList("spaghetti and meatballs, red wine",
					"filet mignon, baked potato, green beans, beer", "grilled salmon, rice pilaf, white wine")));

	@GetMapping("/breakfast")
	public List<String> getBreakfastCombos() {
		for (Meal meal : meals) {
			if (meal.getName().equalsIgnoreCase("breakfast")) {
				return meal.getCombinations();
			}
		}
		return null;
	}

	@GetMapping("/lunch")
	public List<String> getLunchCombos() {
		for (Meal meal : meals) {
			if (meal.getName().equalsIgnoreCase("lunch")) {
				return meal.getCombinations();
			}
		}
		return null;
	}

	@GetMapping("/dinner")
	public List<String> getDinnerCombos() {
		for (Meal meal : meals) {
			if (meal.getName().equalsIgnoreCase("dinner")) {
				return meal.getCombinations();
			}
		}
		return null;
	}
}
