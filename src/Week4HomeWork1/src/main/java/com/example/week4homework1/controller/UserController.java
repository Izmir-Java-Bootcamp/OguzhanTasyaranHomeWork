package com.example.week4homework1.controller;

import com.example.week4homework1.entity.User;
import com.example.week4homework1.exception.CategoryNotExistsException;
import com.example.week4homework1.exception.UserNotExistException;
import com.example.week4homework1.model.UserCreateRequest;
import com.example.week4homework1.model.UserUpdateRequest;
import com.example.week4homework1.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public void createUser(@RequestBody UserCreateRequest userCreateRequest) throws CategoryNotExistsException {
        userService.createUser(userCreateRequest);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) throws UserNotExistException {
        return userService.getUser(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @PutMapping
    public void updateUser(@RequestBody UserUpdateRequest userUpdateRequest) throws CategoryNotExistsException, UserNotExistException {
        userService.updateUser(userUpdateRequest);
    }
}

