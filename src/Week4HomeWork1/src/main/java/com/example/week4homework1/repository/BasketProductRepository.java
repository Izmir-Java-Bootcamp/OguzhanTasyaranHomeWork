package com.example.week4homework1.repository;

import com.example.week4homework1.entity.BasketProducts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketProductRepository extends JpaRepository<BasketProducts, Long> {
    void deleteByBasketIdAndProductId(Long basketId, Long productId);
}
