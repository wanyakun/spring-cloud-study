package com.aioser.cloud.study.config;

import com.aioser.cloud.study.microserviceconsumermoverfallback.user.feign.FeignClientFallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public FeignClientFallback feignClientFallback() {
        return new FeignClientFallback();
    }
}
