package com.company.comws.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.comws.dto.OrderDTO;
import com.company.comws.services.OrderService;

@RestController
@RequestMapping(path="/order")
public class OrderController {

	@Autowired
	OrderService orderServiceObj;
	
	@RequestMapping(params="/details", method=RequestMethod.POST)
	public ResponseEntity<OrderDTO> getOrderDetails(@RequestParam String customerID) {
		return new ResponseEntity<OrderDTO>(new OrderDTO(), HttpStatus.OK);
	}
}
