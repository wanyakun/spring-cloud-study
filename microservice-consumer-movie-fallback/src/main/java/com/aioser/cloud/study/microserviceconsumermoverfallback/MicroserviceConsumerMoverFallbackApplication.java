package com.aioser.cloud.study.microserviceconsumermoverfallback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@EnableCircuitBreaker
public class MicroserviceConsumerMoverFallbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConsumerMoverFallbackApplication.class, args);
	}
}
