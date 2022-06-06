package com.app.bikestore.customers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.bikestore.customers.entity.Customer;
import com.app.bikestore.customers.service.CustomerService;

@RestController
@RequestMapping(value = "/hr/customers")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public ResponseEntity<Page<Customer>> getCustomers(
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size) {
		Page<Customer> customers = customerService.getCustomers(page, size);
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("customerId") Long customerId) {
		Customer customer = customerService.getCustomer(customerId);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

}
