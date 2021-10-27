package com.example.week4homework1.entity;

import lombok.*;
import org.apache.catalina.User;

import javax.persistence.*;

@Entity
@Table(name = "basket")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basket_id", nullable = false)
    private Long basketId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
}
