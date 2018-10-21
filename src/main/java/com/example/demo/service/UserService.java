package com.example.demo.service;

import com.example.demo.dataobject.User;
import com.example.demo.mapper.base.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User getUserById(Integer userId){
        return userMapper.selectByPrimaryKey(userId);
    }
}
