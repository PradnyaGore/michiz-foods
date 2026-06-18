package com.michizfoods.michiz_foods.repository;

import com.michizfoods.michiz_foods.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

    // Find all available meals
    List<Meal> findByIsAvailableTrue();

    // Find meals by category
    List<Meal> findByCategory(String category);

}

