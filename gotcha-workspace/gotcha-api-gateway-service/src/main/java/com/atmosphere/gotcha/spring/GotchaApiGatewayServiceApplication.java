package com.atmosphere.gotcha.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.atmosphere.gotcha.spring")
@EnableDiscoveryClient
@EnableZuulProxy
public class GotchaApiGatewayServiceApplication {

	// Run on browser as
	// http://localhost:8765/api/currency-converter-feign/from/USD/to/INR/quantity/1000
	// http://localhost:8765/api/currency-converter/from/USD/to/INR/quantity/1000
	public static void main(String[] args) {
		SpringApplication.run(GotchaApiGatewayServiceApplication.class, args);
	}
}
