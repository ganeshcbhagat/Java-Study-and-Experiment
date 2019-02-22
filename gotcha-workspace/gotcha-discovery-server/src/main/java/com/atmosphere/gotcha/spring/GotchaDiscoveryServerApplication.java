package com.atmosphere.gotcha.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class GotchaDiscoveryServerApplication {

	// Run on browser as 
	// http://localhost:8761/gotcha.discovery.server/
	// http://localhost:8761
	public static void main(String[] args) {
		SpringApplication.run(GotchaDiscoveryServerApplication.class, args);
	}
}
