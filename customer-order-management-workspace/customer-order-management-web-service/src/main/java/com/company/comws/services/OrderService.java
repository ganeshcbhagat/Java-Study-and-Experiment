package com.company.comws.services;

import java.util.List;
import java.util.Optional;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.company.comws.entity.Customer;
import com.company.comws.entity.Order;
import com.company.comws.exception.ResourceNotFoundException;
import com.company.comws.repositories.CustomerRepository;
import com.company.comws.repositories.OrderRepository;

@Service
@Transactional(propagation=Propagation.SUPPORTS)
public class OrderService {

	@Autowired
	Mapper mapper;
	
	@Autowired
	OrderRepository orderRepositoryObj;
	
	@Autowired
	OrderService orderServiceObj;
	
	public Optional<Order> findOrder(Long orderID) {
		return orderRepositoryObj.findById(orderID);
	}
	
	public Page<Order> findAllCustomer(Pageable pageable) {
		return orderRepositoryObj.findAll(pageable);
	}

	public Order saveOrder(Order orderObj) {
		return orderRepositoryObj.save(orderObj);
	}

	public Order updateOrder(Order orderObj) {
		return orderRepositoryObj.findById(orderObj.getId()).map(orderDBObj -> {
			mapper.map(orderDBObj, orderObj);
			return orderRepositoryObj.save(orderDBObj);
		}).orElseThrow(() -> new ResourceNotFoundException("Id: " + orderObj.getId() + " not found"));
	}

	public boolean deleteOrder(Long orderID) {
		try {
			orderRepositoryObj.deleteById(orderID);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public List<Order> findByCustomerId(Customer customerObj) {
		return orderRepositoryObj.findByCustomerId(customerObj.getId());
	}
	
}
