package com.vs.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vs.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	//@Query("FROM Customer WHERE city = :ct")
	//List<Customer> findByCity(@Param("ct") String city);
	
	List<Customer> findByCity(String city);
}
