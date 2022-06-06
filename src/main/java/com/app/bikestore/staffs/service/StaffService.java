package com.app.bikestore.staffs.service;

import org.springframework.data.domain.Page;

import com.app.bikestore.common.Name;
import com.app.bikestore.staffs.entity.Staff;

public interface StaffService {
	Page<Staff> getStaffs(int page, int size);
	Staff getStaff(Long staffId);
	Name getStaffName(Long staffId);
}
