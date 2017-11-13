package com.aioser.cloud.study.microserviceconsumermoverfallback.user.feign;

import com.aioser.cloud.study.config.FeignConfig;
import com.aioser.cloud.study.microserviceconsumermoverfallback.user.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "microservice-provider-user", configuration = FeignConfig.class, fallback = FeignClientFallback.class)
public interface UserFeignClient {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);
}