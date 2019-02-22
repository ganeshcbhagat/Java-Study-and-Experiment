package com.atmosphere.gotcha.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
@EnableTurbine
public class GotchaMetricsServiceApplication {

	//Run on browser as http://localhost:8008/hystrix
	//Enter the below url 
	//http://localhost:8008/hystrix.stream
	//http://localhost:8008/turbine.stream?cluster=FOREX-SERVICE
	public static void main(String[] args) {
		SpringApplication.run(GotchaMetricsServiceApplication.class, args);
	}
}
