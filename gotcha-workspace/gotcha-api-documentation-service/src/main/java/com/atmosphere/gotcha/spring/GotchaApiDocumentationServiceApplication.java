package com.atmosphere.gotcha.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = "com.atmosphere.gotcha.spring")
@EnableDiscoveryClient
//@EnableZuulProxy
@EnableSwagger2
public class GotchaApiDocumentationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GotchaApiDocumentationServiceApplication.class, args);
	}
}
