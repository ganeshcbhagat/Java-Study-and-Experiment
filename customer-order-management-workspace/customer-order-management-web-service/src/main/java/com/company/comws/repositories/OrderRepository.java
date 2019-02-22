package com.company.comws.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.comws.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	public List<Order> findByCustomerId(Long customerID);
	
}
