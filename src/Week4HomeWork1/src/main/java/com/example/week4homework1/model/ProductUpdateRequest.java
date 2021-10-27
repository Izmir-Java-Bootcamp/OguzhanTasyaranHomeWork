package com.example.week4homework1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductUpdateRequest {
    private Long id;
    private Long categoryId;
    private String name;
    private String description;
    private Double price;
}
