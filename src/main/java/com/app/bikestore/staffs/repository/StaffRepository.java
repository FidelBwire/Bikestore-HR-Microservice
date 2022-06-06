package com.app.bikestore.staffs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.bikestore.staffs.entity.Staff;

public interface StaffRepository extends PagingAndSortingRepository<Staff, Long> {

}
