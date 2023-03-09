package com.wclark7.EldieApi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wclark7.EldieApi.repositories.MealRepository;

@Service
public class MealService {
	private MealRepository mealRepository;

	public MealService(MealRepository mealRepository) {
		this.mealRepository = mealRepository;
	}

	/**
	 * Gets the list of combinations for the meal with the specified name.
	 *
	 * @param mealType the name of the meal to get combinations for
	 * @return the list of combinations for the meal, or null if no meal with that
	 *         name was found
	 */
	public List<String> getMealCombinations(String mealType) {
		return mealRepository.getMealCombinations(mealType);
	}
}