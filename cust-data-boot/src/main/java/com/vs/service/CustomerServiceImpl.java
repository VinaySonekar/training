package com.vs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vs.entity.Customer;
import com.vs.repo.CustomerRepository;
import com.vs.util.CustomerNotFoundException;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repo;
	
	
	@Override
	public void save(Customer c) {
		repo.save(c);

	}

	@Override
	public Customer fetch(int id) throws CustomerNotFoundException {
		
		return repo.findById(id).orElseThrow(()-> new 
				CustomerNotFoundException("No customer with Id: "+id));
	}

	@Override
	public List<Customer> list() {
		
		return repo.findAll();
	}

	@Override
	public void remove(int id) throws CustomerNotFoundException {
		if (!repo.existsById(id)) {
            throw new CustomerNotFoundException("No customer with Id: " + id);
        }
		repo.deleteById(id);

	}

	@Override
	public List<Customer> fetchAllByCity(String ct) {
		
		return repo.findByCity(ct);
	}

}
