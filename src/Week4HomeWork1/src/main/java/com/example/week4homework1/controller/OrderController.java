package com.example.week4homework1.controller;

import com.example.week4homework1.entity.Order;
import com.example.week4homework1.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable Long orderId){
        return orderService.getOrder(orderId);
    }

    @GetMapping("/{userId}")
    public List<Order> getOrders(@PathVariable Long userId){
        return orderService.getAll(userId);
    }


}
