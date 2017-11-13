package com.aioser.cloud.study.microserviceprovideruser.controller;


import com.aioser.cloud.study.microserviceprovideruser.entity.User;
import com.aioser.cloud.study.microserviceprovideruser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

//    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/{id}")
    public User findById(@PathVariable long id) {
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (principal instanceof UserDetails) {
//            UserDetails user = (UserDetails)principal;
//            Collection<? extends GrantedAuthority> collection = user.getAuthorities();
//            for (GrantedAuthority c : collection) {
//                UserController.LOGGER.info("当前用户是{}， 角色是{}", user.getUsername(), c.getAuthority());
//            }
//        }

        User findOne = this.userRepository.findOne(id);
        return findOne;
    }

    @GetMapping("/get")
    public User get(User user) {
        User findOne = this.userRepository.findOne(user.getId());
        return findOne;
    }

    @PostMapping("/post")
    public User post(@RequestBody User user) {
        User findOne = this.userRepository.findOne(user.getId());
        return findOne;
    }
}
