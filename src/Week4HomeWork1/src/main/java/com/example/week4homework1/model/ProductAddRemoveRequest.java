package com.example.week4homework1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductAddRemoveRequest {
    private Long basketId;
    private Long productId;
    private int quantity;
}
