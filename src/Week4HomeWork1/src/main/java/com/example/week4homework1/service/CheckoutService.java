package com.example.week4homework1.service;

import com.example.week4homework1.entity.Order;
import com.example.week4homework1.repository.BasketRepository;
import com.example.week4homework1.repository.OrderRepository;
import com.example.week4homework1.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CheckoutService {
    private final OrderRepository orderRepository;
    private final BasketRepository basketRepository;
    private final UserRepository userRepository;

    public void createOrder(Long userId, Long basketId) {
        orderRepository.save(new Order());
    }
}
