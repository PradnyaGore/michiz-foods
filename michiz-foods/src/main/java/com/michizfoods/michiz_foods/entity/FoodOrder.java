package com.michizfoods.michiz_foods.entity;

// entity name FoodOrder because order is reserved keyword in SQL

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "food_order")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class FoodOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(nullable = false, length = 1000)
    private String mealsOrdered;

    @Column(nullable = false)
    private Double totalAmount;

    @Column(nullable = false)
    private LocalDate orderDate;

    @Column(nullable = false)
    private LocalDate deliveryWeek;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

    public enum OrderStatus {
        PENDING, CONFIRMED, DELIVERED, CANCELLED
    }
}

