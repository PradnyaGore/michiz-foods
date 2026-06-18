package com.michizfoods.michiz_foods.controller;

import com.michizfoods.michiz_foods.dto.MealDTO;
import com.michizfoods.michiz_foods.service.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/meals")
@RequiredArgsConstructor

public class MealController {

    private final MealService mealService;

    // GET /api/meals → available meals (customer)
    @GetMapping
    public ResponseEntity<List<MealDTO>> getAvailableMeals() {
        return ResponseEntity.ok(mealService.getAvailableMeals());
    }

    // GET /api/meals/all → all meals (admin)
    @GetMapping("/all")
    public ResponseEntity<List<MealDTO>> getAllMeals() {
        return ResponseEntity.ok(mealService.getAllMeals());
    }

    // POST /api/meals → add new meal (admin)
    @PostMapping
    public ResponseEntity<MealDTO> createMeal(@RequestBody MealDTO mealDTO) {
        return ResponseEntity.ok(mealService.createMeal(mealDTO));
    }

    // PUT /api/meals/{id}/toggle → toggle availability (admin)
    @PutMapping("/{id}/toggle")
    public ResponseEntity<MealDTO> toggleAvailability(@PathVariable Long id) {
        return ResponseEntity.ok(mealService.toggleAvailability(id));
    }
}
