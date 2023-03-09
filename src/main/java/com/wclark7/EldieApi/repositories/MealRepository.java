package com.wclark7.EldieApi.repositories;

import java.util.List;

import com.wclark7.EldieApi.models.Meal;
import com.wclark7.EldieApi.storage.MealStorage;

public class MealRepository {
	private MealStorage mealStorage;

	public MealRepository(MealStorage mealStorage) {
		this.mealStorage = mealStorage;
	}

	/**
	 * Gets the list of combinations for the meal with the specified name.
	 *
	 * @param mealType the name of the meal to get combinations for
	 * @return the list of combinations for the meal, or null if no meal with that
	 *         name was found
	 */
	public List<String> getMealCombinations(String mealType) {
		for (Meal meal : mealStorage.getAllMeals()) {
			if (meal.getName().equalsIgnoreCase(mealType)) {
				return meal.getCombinations();
			}
		}
		// If no meal with that name was found, return null
		return null;
	}
}