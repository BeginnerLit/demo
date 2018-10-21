package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisSerivice {

    @Autowired
    RedisTemplate redisTemplate;

    public String setList(String value){
        redisTemplate.opsForList().rightPush("testList",value);
        return "success";
    }

    public String getList(){
        return redisTemplate.opsForList().rightPop("testList").toString();
    }
}
