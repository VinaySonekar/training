package com.vs.service;

import java.time.LocalDate;
import java.util.List;

import com.vs.entity.Customer;

import com.vs.util.CustomerNotFoundException;

public interface CustomerService {
	
	public void save(Customer c);
	
	public Customer fetch(int id) throws CustomerNotFoundException;
	
	public List<Customer> list();
	
	public void remove(int id) throws CustomerNotFoundException;
	
	public List<Customer> fetchAllByCity(String ct);

}
