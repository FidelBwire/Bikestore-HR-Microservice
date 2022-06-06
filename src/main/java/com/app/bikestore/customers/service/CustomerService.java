package com.app.bikestore.customers.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.app.bikestore.customers.entity.Customer;

public interface CustomerService {
	List<Customer> getCustomers();
	Customer getCustomer(Long customerId);
	Page<Customer> getCustomers(int page, int size);
}
