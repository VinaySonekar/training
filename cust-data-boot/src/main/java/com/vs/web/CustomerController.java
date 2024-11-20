package com.vs.web;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vs.entity.Customer;

import com.vs.service.CustomerService;
import com.vs.util.CustomerNotFoundException;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@PostMapping(value="/save", consumes="application/json")
	public String saveCustomer(@RequestBody Customer c){
		service.save(c);
		return "Customer saved.";
	}
	
	@GetMapping(value="/fetch/{id}", produces= "application/json")
	public Customer getCustomer(@PathVariable("id") int id) throws CustomerNotFoundException {
		Customer cust= service.fetch(id);
		return cust;
		
	}
	
	@GetMapping(value="/list", produces= "application/json")
	public List<Customer> listCustomer(){
		return service.list();
		
	}
	
	@GetMapping(value="/delete/{id}", produces= "application/json")
	public String deleteCustomer(@PathVariable("id") int id) throws CustomerNotFoundException {
		service.remove(id);
		return "Customer deleted.";
	}
	
	
	@GetMapping(value="/findcity/{cty}", produces= "application/json")
	public List<Customer> getCustomerbyCity(@PathVariable("cty") String cty){
		return service.fetchAllByCity(cty);
	}
	
	@ExceptionHandler(value=CustomerNotFoundException.class)
	public ResponseEntity<Object> handleException(CustomerNotFoundException ex){
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	
}
