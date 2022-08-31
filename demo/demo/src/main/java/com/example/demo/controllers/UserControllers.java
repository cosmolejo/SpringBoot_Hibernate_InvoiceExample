package com.example.demo.controllers;


import com.example.demo.entities.User;
import com.example.demo.services.UserServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserControllers {

    UserServices service;

    public UserControllers(UserServices services) {

        this.service = services;
    }

    @GetMapping("/user")
    public List<User> getUsers() {
        return this.service.getUsers();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") long id){
        return this.service.getUser(id);

    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return  this.service.createUser(user);

    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable("id") long id, @RequestBody User user){
        return this.service.updateUser(id,user);
    }

    @DeleteMapping("/user/{id}")
    public Boolean deleteUser(@PathVariable("id") long id){
        return this.service.deleteUser(id);

    }
}
