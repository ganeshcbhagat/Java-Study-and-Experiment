package com.company.comws;

import javax.annotation.PostConstruct;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.company.comws.entity.Customer;
import com.company.comws.entity.Order;
import com.company.comws.services.CustomerService;
import com.company.comws.services.OrderService;

@Configuration
@EnableJpaAuditing
@EnableJpaRepositories
@ComponentScan(basePackages= {"com.company.comws"})
@EntityScan(basePackages= {"com.company.comws.entity"})
public class CustomerOrderManagementConfiguration {
	
	@Bean
	public Mapper dozerBeanMapper() {
		return new DozerBeanMapper();	
	}
	
	@Autowired
	CustomerService customerServiceObj;
	
	@Autowired
	OrderService orderServiceObj;
	
	@PostConstruct
	public void initDummyDataInTables() {
		
		for(int i=1;i<15;i++) {
			Customer customer = new Customer(new Long(i), "name "+i, "city "+i);
			customerServiceObj.saveCustomer(customer);
			Order order = new Order(new Long(i), "productName "+i, i*0.5F, customer);
			orderServiceObj.saveOrder(order);
		}
		
		for(int i=1;i<15;i++) {
			System.out.println("customer="+customerServiceObj.findCustomer(new Long(i)));
		}
	}
}
