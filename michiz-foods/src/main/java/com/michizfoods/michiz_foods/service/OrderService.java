package com.michizfoods.michiz_foods.service;

import com.michizfoods.michiz_foods.dto.OrderRequestDTO;
import com.michizfoods.michiz_foods.dto.OrderResponseDTO;
import com.michizfoods.michiz_foods.entity.*;
import com.michizfoods.michiz_foods.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class OrderService {
    private final FoodOrderRepository foodOrderRepository;
    private final CustomerRepository customerRepository;
    private final MealRepository mealRepository;

    // Place a new order
    public OrderResponseDTO placeOrder(OrderRequestDTO request) {

        // Rule 1: Only allow orders on Tuesday
        LocalDate today = LocalDate.now();
        if (today.getDayOfWeek() != DayOfWeek.TUESDAY) {
            throw new RuntimeException(
                    "Orders can only be placed on Tuesdays! Today is: "
                            + today.getDayOfWeek()
            );
        }

        // Rule 2: Find existing customer or create new one
        Customer customer = customerRepository
                .findByEmail(request.getCustomerEmail())
                .orElseGet(() -> customerRepository.save(
                        Customer.builder()
                                .name(request.getCustomerName())
                                .email(request.getCustomerEmail())
                                .phone(request.getCustomerPhone())
                                .build()
                ));

        // Rule 3: Prevent duplicate orders on same Tuesday
        if (foodOrderRepository.existsByCustomerIdAndOrderDate(
                customer.getId(), today)) {
            throw new RuntimeException(
                    "You have already placed an order this Tuesday!"
            );
        }

        // Rule 4: Fetch meals and calculate total
        List<Long> mealIds = request.getMealIds();
        List<Integer> quantities = request.getQuantities();

        StringBuilder mealsOrdered = new StringBuilder();
        double totalAmount = 0.0;

        for (int i = 0; i < mealIds.size(); i++) {
            Meal meal = mealRepository.findById(mealIds.get(i))
                    .orElseThrow(() -> new RuntimeException("Meal not found"));
            int qty = quantities.get(i);
            totalAmount += meal.getPrice() * qty;
            mealsOrdered.append(meal.getName())
                    .append(" x").append(qty)
                    .append(", ");
        }

        // Remove trailing comma
        String mealsText = mealsOrdered.toString()
                .replaceAll(", $", "");

        // Rule 5: Delivery is next Monday
        LocalDate deliveryWeek = today.with(
                TemporalAdjusters.next(DayOfWeek.MONDAY)
        );

        // Rule 6: Save the order
        FoodOrder order = FoodOrder.builder()
                .customer(customer)
                .mealsOrdered(mealsText)
                .totalAmount(totalAmount)
                .orderDate(today)
                .deliveryWeek(deliveryWeek)
                .status(FoodOrder.OrderStatus.PENDING)
                .build();

        FoodOrder saved = foodOrderRepository.save(order);
        return toDTO(saved);
    }

    // Get all orders (admin)
    public List<OrderResponseDTO> getAllOrders() {
        return foodOrderRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Update order status (admin)
    public OrderResponseDTO updateStatus(Long orderId, String status) {
        FoodOrder order = foodOrderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(FoodOrder.OrderStatus.valueOf(status));
        return toDTO(foodOrderRepository.save(order));
    }

    // Convert Entity to DTO
    private OrderResponseDTO toDTO(FoodOrder order) {
        return OrderResponseDTO.builder()
                .orderId(order.getId())
                .customerName(order.getCustomer().getName())
                .customerEmail(order.getCustomer().getEmail())
                .customerPhone(order.getCustomer().getPhone())
                .mealsOrdered(order.getMealsOrdered())
                .totalAmount(order.getTotalAmount())
                .orderDate(order.getOrderDate())
                .deliveryWeek(order.getDeliveryWeek())
                .status(order.getStatus().name())
                .build();
    }
}

