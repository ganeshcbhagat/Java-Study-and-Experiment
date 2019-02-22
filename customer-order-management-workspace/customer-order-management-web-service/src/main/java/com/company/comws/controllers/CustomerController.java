package com.company.comws.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.company.comws.dto.CustomerDTO;
import com.company.comws.entity.Customer;
import com.company.comws.services.CustomerService;

@RestController
@RequestMapping(path="/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerServiceObj;
	
	@Autowired
	Mapper mapper;
	
	//http://localhost:8080/comws/customer/details?page=0&size=22&sort=createdAt,desc
	@RequestMapping(path ="/details", method=RequestMethod.GET)
    public Page<CustomerDTO> getAllCustomers(Pageable pageable) {
		Page<Customer> pageCustomerObj = customerServiceObj.findAllCustomer(pageable);
		List<CustomerDTO> customerListObj = new ArrayList<CustomerDTO>();
		pageCustomerObj.getContent().forEach(customerObj->{
			CustomerDTO customerDTOObj = new CustomerDTO();
			mapper.map(customerObj, customerDTOObj);
			customerListObj.add(customerDTOObj);
		});
		Page<CustomerDTO> pageCustomerDTOObj = new PageImpl<CustomerDTO>(customerListObj);
		mapper.map(pageCustomerObj, pageCustomerDTOObj);
		return pageCustomerDTOObj;
    }

	//http://localhost:8080/comws/customer/details/14
	@RequestMapping(path="/details/{id}", method=RequestMethod.GET)
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable long id) {
		Optional<Customer> optionalCust = customerServiceObj.findCustomer(id);
		if(optionalCust.isPresent()) {
			CustomerDTO customerDTOObj = new CustomerDTO(); 
			mapper.map(optionalCust.get(), customerDTOObj);
			return new ResponseEntity<CustomerDTO>(customerDTOObj, HttpStatus.OK);
		}
		return new ResponseEntity<CustomerDTO>(HttpStatus.NOT_FOUND);
    }
	
	//http://localhost:8080/comws/customer/save
	@RequestMapping(path="/save", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO saveCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
		Customer customer = new Customer();
		mapper.map(customerDTO, customer);
		customerServiceObj.saveCustomer(customer);
		mapper.map(customer, customerDTO);
        return customerDTO;
    }

	//http://localhost:8080/comws/customer/update
    @RequestMapping(path="/update", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO updateCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
    	Customer customer = new Customer();
		mapper.map(customerDTO, customer);
    	customer = customerServiceObj.updateCustomer(customer);
    	mapper.map(customer, customerDTO);
        return customerDTO;
    }
    
    //http://localhost:8080/comws/customer/delete/12
    @RequestMapping(path="/delete/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CustomerDTO> deleteCustomer(@PathVariable Long id) {
    	CustomerDTO customerDTOObj = new CustomerDTO();
    	Customer customer = customerServiceObj.deleteCustomer(id);
    	if(customer!=null) {
    		mapper.map(customer, customerDTOObj);
    		return new ResponseEntity<CustomerDTO>(customerDTOObj, HttpStatus.OK);
    	} else {
    		return new ResponseEntity<CustomerDTO>(HttpStatus.NOT_FOUND);
    	}
    }
}
