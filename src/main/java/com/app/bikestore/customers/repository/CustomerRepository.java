package com.app.bikestore.customers.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.bikestore.customers.entity.Customer;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

}
