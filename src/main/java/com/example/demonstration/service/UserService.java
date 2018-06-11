package com.example.demonstration.service;

import com.example.demonstration.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void save(User user);

    User getByName(String name);

    void delete(String name);

    void update(User user);
}
