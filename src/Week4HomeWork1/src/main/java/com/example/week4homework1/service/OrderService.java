package com.example.week4homework1.service;

import com.example.week4homework1.entity.Order;
import com.example.week4homework1.repository.OrderRepository;
import com.example.week4homework1.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final UserRepository userRepository;

    public Order getOrder(Long orderId) {
        return orderRepository.getById(orderId);
    }

    public List<Order> getAll(Long userId) {
        return orderRepository.findAllByUser(userRepository.getById(userId));
    }
}
