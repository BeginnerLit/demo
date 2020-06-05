package com.example.demo.controller;

import com.example.demo.dataobject.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getUser")
    public User getUserById(){
        return userService.getUserById(1000);    
    }
}
