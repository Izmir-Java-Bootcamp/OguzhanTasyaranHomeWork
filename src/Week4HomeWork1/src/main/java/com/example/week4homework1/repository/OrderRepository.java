package com.example.week4homework1.repository;

import com.example.week4homework1.entity.Order;
import com.example.week4homework1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByUser(User user);


}
