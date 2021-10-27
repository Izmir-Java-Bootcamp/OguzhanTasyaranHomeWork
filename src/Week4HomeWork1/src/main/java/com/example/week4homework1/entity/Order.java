package com.example.week4homework1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "order")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Order {
    @Id
    @Column(name = "order_id",nullable = false)
    private Long orderId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
}
