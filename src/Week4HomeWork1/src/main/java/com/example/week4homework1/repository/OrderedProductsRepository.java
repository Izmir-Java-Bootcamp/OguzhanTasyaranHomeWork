package com.example.week4homework1.repository;

import com.example.week4homework1.entity.OrderedProducts;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OrderedProductsRepository extends JpaRepository<OrderedProducts, Long> {
}
