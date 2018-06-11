package com.example.demonstration.dao;

import com.example.demonstration.entity.User;
import com.example.demonstration.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO demo.user (name, email, age) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getAge());
    }

    @Override
    public User getByName(String name) {
        String sql = "SELECT * FROM demo.user WHERE user.name=?";
        return jdbcTemplate.queryForObject(sql, new UserMapper(), name);
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM demo.user";
        return jdbcTemplate.query(sql, new UserMapper());
    }

    @Override
    public void delete(String name) {
        String sql = "DELETE FROM user WHERE name=?";
        jdbcTemplate.update(sql, name);
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE demo.user SET email=?, age=? WHERE name=?";
        jdbcTemplate.update(sql, user.getName(), user.getName(), user.getAge());
    }
}
