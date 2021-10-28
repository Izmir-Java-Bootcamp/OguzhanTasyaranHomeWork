package com.example.week4homework1.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user_order")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Order {
    @Id
    @Column(name = "order_id", nullable = false)
    private Long orderId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

}
