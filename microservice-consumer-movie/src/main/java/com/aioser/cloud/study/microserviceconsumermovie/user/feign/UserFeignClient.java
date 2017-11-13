package com.aioser.cloud.study.microserviceconsumermovie.user.feign;

import com.aioser.cloud.study.config.FeignLogConfiguration;
import com.aioser.cloud.study.microserviceconsumermovie.user.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "microservice-provider-user", configuration = FeignLogConfiguration.class)//, fallback = FeignClientFallback.class)
public interface UserFeignClient {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);

    // 该请求不会成功
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public User get0(User user);

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public User get1(@RequestParam("id") Long id, @RequestParam("username") String username);

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public User get2(@RequestParam Map<String, Object> map);

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public User post(@RequestBody User user);
}


//@Component
//class FeignClientFallback implements UserFeignClient {
//
//    private User defaultUser() {
//        User user = new User();
//        user.setId(-1L);
//        user.setUsername("默认用户");
//        return user;
//    }
//
//    @Override
//    public User findById(Long id) {
//        return defaultUser();
//    }
//
//    @Override
//    public User get0(User user) {
//        return defaultUser();
//    }
//
//    @Override
//    public User get1(Long id, String username) {
//        return defaultUser();
//    }
//
//    @Override
//    public User get2(Map<String, Object> map) {
//        return defaultUser();
//    }
//
//    @Override
//    public User post(User user) {
//        return defaultUser();
//    }
//}