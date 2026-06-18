package com.michizfoods.michiz_foods.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "meal")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 500)
    private String description;

    @Column(nullable = false)
    private Double price;

    private String category;

    @Column(nullable = false)
    private Boolean isAvailable = true;
}
