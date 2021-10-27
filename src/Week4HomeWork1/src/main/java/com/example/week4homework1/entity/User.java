package com.example.week4homework1.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "basket")
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long user_id;

    @Column(name = "name_surname", nullable = false)
    private String nameSurname;
}
