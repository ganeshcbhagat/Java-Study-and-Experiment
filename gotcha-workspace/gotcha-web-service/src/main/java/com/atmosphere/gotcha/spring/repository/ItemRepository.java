package com.atmosphere.gotcha.spring.repository;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atmosphere.gotcha.spring.entity.Item;
import com.atmosphere.gotcha.spring.exception.ResourceNotFoundException;

@Repository
@Lazy
public interface ItemRepository extends JpaRepository<Item, Long>{
 
	public List<Item> findByName(String name)  throws IllegalArgumentException, ResourceNotFoundException;
	
}