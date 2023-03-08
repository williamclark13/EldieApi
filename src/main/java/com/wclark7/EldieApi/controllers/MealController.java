package com.wclark7.EldieApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wclark7.EldieApi.repositories.MealRepository;
import com.wclark7.EldieApi.services.MealService;
import com.wclark7.EldieApi.storage.MealStorage;

@RestController
@RequestMapping(path = "/api/v1/meal")
public class MealController {

	private MealService mealService;

	public MealController() {
		MealStorage mealStorage = new MealStorage();
		MealRepository mealRepository = new MealRepository(mealStorage);
		this.mealService = new MealService(mealRepository);
	}

	@GetMapping("/breakfast")
	public List<String> getBreakfastCombos() {
		return mealService.getMealCombinations("breakfast");
	}

	@GetMapping("/lunch")
	public List<String> getLunchCombos() {
		return mealService.getMealCombinations("lunch");
	}

	@GetMapping("/dinner")
	public List<String> getDinnerCombos() {
		return mealService.getMealCombinations("dinner");
	}
}
