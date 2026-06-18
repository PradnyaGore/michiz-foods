package com.michizfoods.michiz_foods.repository;

import com.michizfoods.michiz_foods.entity.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long> {

    // Get all orders for a specific customer
    List<FoodOrder> findByCustomerId(Long customerId);

    // Check if customer already ordered this week
    boolean existsByCustomerIdAndOrderDate(Long customerId, LocalDate orderDate);
}
