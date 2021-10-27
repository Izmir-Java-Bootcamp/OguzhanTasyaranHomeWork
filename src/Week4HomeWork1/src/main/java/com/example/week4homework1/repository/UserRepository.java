package com.example.week4homework1.repository;

import com.example.week4homework1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
