package com.app.bikestore.customers.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.app.bikestore.customers.entity.Customer;
import com.app.bikestore.customers.repository.CustomerRepository;
import com.app.bikestore.customers.service.CustomerService;
import com.app.bikestore.exception.handlers.ResourceNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override 
	public List<Customer> getCustomers() {
		List<Customer> customersList = new ArrayList<>();
		customerRepository.findAll().forEach(customer -> customersList.add(customer));
		return customersList;
	}
	
	@Override 
	public Page<Customer> getCustomers(int page, int size) {
		PageRequest pageRequest = PageRequest.of(page, size);
		Page<Customer> customersPage = customerRepository.findAll(pageRequest);
		
		List<Customer> customersList = new ArrayList<>();
		customersPage.forEach(customer -> customersList.add(customer));
		
		return new PageImpl<Customer>(customersList, pageRequest, customerRepository.count());
	}

	@Override
	public Customer getCustomer(Long customerId) {
		return customerRepository.findById(customerId)
					.orElseThrow(() -> new ResourceNotFoundException
							("No customer with id " + customerId));
	}
}
