package com.example.week4homework1.service;

import com.example.week4homework1.entity.User;
import com.example.week4homework1.model.UserCreateRequest;
import com.example.week4homework1.model.UserUpdateRequest;
import com.example.week4homework1.repository.UserRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createUser(UserCreateRequest userCreateRequest) {
        userRepository.save(new User(null, userCreateRequest.getNameSurname()));
    }

    public User getUser(Long id) {
        return userRepository.getById(id);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public void updateUser(UserUpdateRequest userUpdateRequest) {
        User user = userRepository.getById(userUpdateRequest.getId());
        user.setNameSurname(userUpdateRequest.getNameSurname());
        userRepository.save(user);
    }
}
