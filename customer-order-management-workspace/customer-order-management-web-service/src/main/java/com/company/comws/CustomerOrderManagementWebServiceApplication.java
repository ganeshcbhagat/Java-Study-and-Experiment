package com.company.comws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerOrderManagementWebServiceApplication {

	/* http://localhost:8080/comws/h2-console/
	Select below details (look <application.properties> file)
	saved setting : Generic h2 (Embedded)
	jdbc-url	: jdbc:h2:mem:comwsDB
	user Name	: sa
	password	: */
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerOrderManagementWebServiceApplication.class, args);
	}
}
