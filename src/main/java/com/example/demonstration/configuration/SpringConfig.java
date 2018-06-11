package com.example.demonstration.configuration;

import com.example.demonstration.dao.UserDAOImpl;
import com.example.demonstration.dao.UserDao;
import com.example.demonstration.service.UserService;
import com.example.demonstration.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.example.demonstration.service", "com.example.demonstration.dao"})
public class SpringConfig {

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("1q2w3e3e2w1q4r");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }

}
