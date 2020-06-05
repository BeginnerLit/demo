package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "/test1",tags = "测试接口模块")
@RestController
@RequestMapping("/test")
public class HelloController {

    @ApiOperation(value = "测试swagger")
    @GetMapping("/hello")
    public String sayHello(){
        return  "Hello World";
    }
}
