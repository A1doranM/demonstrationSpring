package com.example.demonstration.service;

import com.example.demonstration.dao.UserDao;
import com.example.demonstration.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    public UserDao userDao;

    public List<User> findAll(){
        return userDao.findAll();
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public User getByName(String name) {
        return userDao.getByName(name);
    }

    @Override
    public void delete(String name) {
        userDao.delete(name);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }
}
