package com.wclark7.EldieApi.repositories;

import java.util.List;

import com.wclark7.EldieApi.models.Meal;
import com.wclark7.EldieApi.storage.MealStorage;

public class MealRepository {

	private MealStorage mealStorage;

	public MealRepository(MealStorage mealStorage) {
		this.mealStorage = mealStorage;
	}

	public List<String> getMealCombinations(String mealType) {
		for (Meal meal : mealStorage.getAllMeals()) {
			if (meal.getName().equalsIgnoreCase(mealType)) {
				return meal.getCombinations();
			}
		}
		return null;
	}

}
