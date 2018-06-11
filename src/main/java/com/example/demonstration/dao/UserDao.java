package com.example.demonstration.dao;

import com.example.demonstration.entity.User;

import java.util.List;

public interface UserDao {

    void save(User user);

    User getByName(String name);

    List<User> findAll();

    void delete(String name);

    void update(User user);

}
