package com.aioser.cloud.study.microserviceprovideruser.controller;


import com.aioser.cloud.study.microserviceprovideruser.entity.User;
import com.aioser.cloud.study.microserviceprovideruser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findById(@PathVariable long id) {
        User findOne = this.userRepository.findOne(id);
        return findOne;
    }
}
