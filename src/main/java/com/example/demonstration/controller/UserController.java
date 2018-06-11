package com.example.demonstration.controller;

import com.example.demonstration.entity.User;
import com.example.demonstration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model){
        model.addAttribute("users", userService.findAll());
        return "usersList";
    }

    @GetMapping("/user/{name}")
    public String getByName(@PathVariable("name") String name, Model model){
        model.addAttribute("user", userService.getByName(name));
        return "showUser";
    }

    @GetMapping("/addUser")
    public String createUserPage(){
        return "createUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/users";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/user/" + user.getName();
    }

    @GetMapping("/delete/{name}")
    public String deleteUser(@PathVariable("name") String name){
        userService.delete(name);
        return "redirect:/users";
    }

    @GetMapping("/update/{name}")
    public String updateUser(@PathVariable("name") String name, Model model){
        model.addAttribute("user", userService.getByName(name));
        return "editUser";
    }
}
