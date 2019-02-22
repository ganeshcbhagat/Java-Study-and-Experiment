package com.company.comws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.comws.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
