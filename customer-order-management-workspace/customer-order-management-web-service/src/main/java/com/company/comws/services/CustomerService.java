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

@Service
@Transactional(propagation=Propagation.SUPPORTS)
public class CustomerService {

	@Autowired
	Mapper mapper;
	
	@Autowired
	CustomerRepository customerRepositoryObj;
	@Autowired
	OrderService orderServiceObj;
	
	public Optional<Customer> findCustomer(Long customerID) {
		return customerRepositoryObj.findById(customerID);
	}
	
	public Page<Customer> findAllCustomer(Pageable pageable) {
		return customerRepositoryObj.findAll(pageable);
	}

	public Customer saveCustomer(Customer customerObj) {
		return customerRepositoryObj.save(customerObj);
	}

	public Customer updateCustomer(Customer customerObj) {
		return customerRepositoryObj.findById(customerObj.getId()).map(customerDBObj -> {
			mapper.map(customerDBObj, customerObj);
			return customerRepositoryObj.save(customerDBObj);
		}).orElseThrow(() -> new ResourceNotFoundException("Id: " + customerObj.getId() + " not found"));
	}

	public Customer deleteCustomer(Long customerID) {
		return customerRepositoryObj.findById(customerID).map(customerObj -> {
			try {
				List<Order> orderList = orderServiceObj.findByCustomerId(customerObj);	
				orderList.forEach(orderObj -> {
					orderServiceObj.deleteOrder(orderObj.getId());
				});
				customerRepositoryObj.delete(customerObj);
				return customerObj;
			} catch(Exception e) {
				return null;
			}
		}).orElseThrow(() -> new ResourceNotFoundException("Id: " + customerID + " not found"));
	}

}