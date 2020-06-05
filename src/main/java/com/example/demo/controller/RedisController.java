package com.example.demo.controller;

import com.example.demo.service.RedisSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    RedisSerivice redisSerivice;

    @PutMapping("/redisSet")
    public String setList(){
        return redisSerivice.setList("Hello World");
    }

    @GetMapping("/redisGet")
    public String getList(){
        return redisSerivice.getList();
    }
}
