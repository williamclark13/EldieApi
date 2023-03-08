package com.wclark7.EldieApi.services;

import java.util.List;

import com.wclark7.EldieApi.repositories.MealRepository;

public class MealService {

	private MealRepository mealRepository;

	public MealService(MealRepository mealRepository) {
		this.mealRepository = mealRepository;
	}

	public List<String> getMealCombinations(String mealType) {
		return mealRepository.getMealCombinations(mealType);
	}
}