package com.aioser.cloud.study.microserviceconsumermoverfallback.user.feign;

import com.aioser.cloud.study.microserviceconsumermoverfallback.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class FeignClientFallback implements UserFeignClient {

    private User defaultUser() {
        User user = new User();
        user.setId(-1L);
        user.setUsername("默认用户");
        return user;
    }

    @Override
    public User findById(Long id) {
        return defaultUser();
    }
}
