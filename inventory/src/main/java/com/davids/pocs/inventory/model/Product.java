package com.davids.pocs.inventory.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private int quantity;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
