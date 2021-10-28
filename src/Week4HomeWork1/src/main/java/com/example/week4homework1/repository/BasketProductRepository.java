package com.example.week4homework1.repository;

import com.example.week4homework1.entity.Basket;
import com.example.week4homework1.entity.BasketProducts;
import com.example.week4homework1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BasketProductRepository extends JpaRepository<BasketProducts, Long> {
    void deleteByBasketAndProduct(Basket basket, Product product);

    List<BasketProducts> findAllByBasket(Basket basket);
}
