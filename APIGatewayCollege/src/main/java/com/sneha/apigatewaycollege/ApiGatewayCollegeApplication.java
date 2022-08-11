package com.sneha.apigatewaycollege;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableEurekaClient
public class ApiGatewayCollegeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayCollegeApplication.class, args);
	}

}
