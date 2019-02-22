package com.atmosphere.gotcha.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class GotchaConfigServerApplication {
	
	// Look the project https://github.com/eugenp/tutorials/tree/master/spring-cloud/spring-cloud-bootstrap 
	public static void main(String[] args) {
		SpringApplication.run(GotchaConfigServerApplication.class, args);
	}

}

