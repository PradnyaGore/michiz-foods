package com.michizfoods.michiz_foods.dto;

import lombok.*;
import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder

public class OrderRequestDTO {
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private List<Long> mealIds;
    private List<Integer> quantities;
}
