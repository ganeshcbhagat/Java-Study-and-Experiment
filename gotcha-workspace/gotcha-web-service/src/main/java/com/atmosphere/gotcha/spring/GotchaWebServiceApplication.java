package com.atmosphere.gotcha.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GotchaWebServiceApplication {

	// Run on browser as
	// http://localhost:8000/gotcha.web.service/found/item/watch/
	// http://localhost:8000/gotcha.web.service/h2-console/login.do
	// POST : http://localhost:8000/gotcha.web.service/actuator/shutdown
	
	// Get All endpoints
	//http://localhost:8000/gotcha.web.service/actuator
	
	//For Internationalization message
	//http://localhost:8000/gotcha.web.service/found/item/deleteAll?lang=de
	//http://localhost:8000/gotcha.web.service/found/item/delete/-2?lang=en
	
	public static void main(String[] args) {
		SpringApplication.run(GotchaWebServiceApplication.class, args);
	}

}
