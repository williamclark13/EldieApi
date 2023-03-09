package com.wclark7.EldieApi.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wclark7.EldieApi.repositories.MealRepository;
import com.wclark7.EldieApi.services.MealService;
import com.wclark7.EldieApi.storage.MealStorage;

@RestController
@RequestMapping(path = "/api/meal")
public class MealController {
	private MealService mealService;

	public MealController() {
		MealStorage mealStorage = new MealStorage();
		MealRepository mealRepository = new MealRepository(mealStorage);
		this.mealService = new MealService(mealRepository);
	}

	/**
	 * Retrieves the breakfast combos
	 * 
	 * @return breakfast combos
	 */
	@GetMapping("/breakfast")
	public ResponseEntity<List<String>> getBreakfastCombos() {
		List<String> combos = mealService.getMealCombinations("breakfast");
		if (combos == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(combos);
		}
	}

	/**
	 * Retrieves the lunch combos
	 * 
	 * @return lunch combos
	 */
	@GetMapping("/lunch")
	public ResponseEntity<List<String>> getLunchCombos() {
		List<String> combos = mealService.getMealCombinations("lunch");
		if (combos == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(combos);
		}
	}

	/**
	 * Retrieves the dinner combos
	 * 
	 * @return dinner combos
	 */
	@GetMapping("/dinner")
	public ResponseEntity<List<String>> getDinnerCombos() {
		List<String> combos = mealService.getMealCombinations("dinner");
		if (combos == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(combos);
		}
	}
}