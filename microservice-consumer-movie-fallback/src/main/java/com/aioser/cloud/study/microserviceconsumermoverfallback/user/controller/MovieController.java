package com.aioser.cloud.study.microserviceconsumermoverfallback.user.controller;

import com.aioser.cloud.study.microserviceconsumermoverfallback.user.entity.User;
import com.aioser.cloud.study.microserviceconsumermoverfallback.user.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return this.userFeignClient.findById(id);
    }
}
