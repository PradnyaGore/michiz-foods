package com.michizfoods.michiz_foods.dto;

import lombok.*;
import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder

public class OrderResponseDTO {
    private Long orderId;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String mealsOrdered;
    private Double totalAmount;
    private LocalDate orderDate;
    private LocalDate deliveryWeek;
    private String status;
}
