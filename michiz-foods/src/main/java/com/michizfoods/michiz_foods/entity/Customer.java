package com.michizfoods.michiz_foods.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity               // tells hibernate this java class is DB table (without this, it ignores the class)
@Table(name = "customer")  // tells the exact name for table in PostgreSQL. if not, it uses class name
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder         // lombok -- lets u create objects

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)   // means no two customers can have the same email
    private String email;

    private String phone;
}
