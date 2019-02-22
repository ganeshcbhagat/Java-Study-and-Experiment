package com.atmosphere.gotcha.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin2.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZipkinServer
public class GotchaTraceServiceApplication {

	// Run on browser as 
	// http://localhost:9411/gotcha.trace.service/zipkin/
	public static void main(String[] args) {
		SpringApplication.run(GotchaTraceServiceApplication.class, args);
	}
}
