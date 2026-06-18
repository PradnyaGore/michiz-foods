package com.michizfoods.michiz_foods.service;

import com.michizfoods.michiz_foods.dto.MealDTO;
import com.michizfoods.michiz_foods.entity.Meal;
import com.michizfoods.michiz_foods.repository.MealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class MealService {
    private final MealRepository mealRepository;

    // Get all available meals (customer view)
    public List<MealDTO> getAvailableMeals() {
        return mealRepository.findByIsAvailableTrue()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Get all meals (admin view)
    public List<MealDTO> getAllMeals() {
        return mealRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Add new meal (admin)
    public MealDTO createMeal(MealDTO dto) {
        Meal meal = Meal.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .category(dto.getCategory())
                .isAvailable(true)
                .build();
        return toDTO(mealRepository.save(meal));
    }

    // Toggle meal availability (admin)
    public MealDTO toggleAvailability(Long id) {
        Meal meal = mealRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Meal not found with id: " + id));
        meal.setIsAvailable(!meal.getIsAvailable());
        return toDTO(mealRepository.save(meal));
    }

    // Convert Entity to DTO
    private MealDTO toDTO(Meal meal) {
        return MealDTO.builder()
                .id(meal.getId())
                .name(meal.getName())
                .description(meal.getDescription())
                .price(meal.getPrice())
                .category(meal.getCategory())
                .isAvailable(meal.getIsAvailable())
                .build();
    }
}
