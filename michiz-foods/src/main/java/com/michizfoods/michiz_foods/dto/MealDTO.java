package com.michizfoods.michiz_foods.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder

public class MealDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String category;
    private Boolean isAvailable;
}

