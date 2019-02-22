package com.creditSuisse.controller;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

	//http://localhost:8080/edoc/login/auth?emailId=ganesh@cog.cm%22&password=%22hellonewPass%22
	@RequestMapping(path="/auth", method=RequestMethod.POST)
	public ResponseEntity<String> doLogin(@PathParam(value = "testEmail") String emailId, @PathParam(value = "testPassword") String password) {
		System.out.println("emailId : " + emailId + " password : " + password);
		ResponseEntity<String>  responseEntityObj = new ResponseEntity<String>("Hello "+emailId, HttpStatus.OK); 
		return responseEntityObj ;
	}
	
	@RequestMapping(path="/auth1", method=RequestMethod.GET)
	public ResponseEntity<String> doLoginTest() {
		System.out.println("Hello");
		ResponseEntity<String>  responseEntityObj = new ResponseEntity<String>("Hello iam here", HttpStatus.OK); 
		return responseEntityObj ;
	}
	
}
