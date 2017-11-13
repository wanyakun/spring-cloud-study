package com.aioser.cloud.study.microservicehystrixturbin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class MicroserviceHystrixTurbinApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceHystrixTurbinApplication.class, args);
	}
}
