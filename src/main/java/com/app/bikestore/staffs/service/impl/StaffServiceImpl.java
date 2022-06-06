package com.app.bikestore.staffs.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.app.bikestore.common.Name;
import com.app.bikestore.exception.handlers.ResourceNotFoundException;
import com.app.bikestore.staffs.entity.Staff;
import com.app.bikestore.staffs.repository.StaffRepository;
import com.app.bikestore.staffs.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService {
	
	@Autowired
	private StaffRepository staffRepository;

	@Override
	public Page<Staff> getStaffs(int page, int size) {
		PageRequest pageRequest = PageRequest.of(page, size);
		Page<Staff> staffsPage = staffRepository.findAll(pageRequest);
		
		List<Staff> staffsList = new ArrayList<>();
		staffsPage.forEach(staff -> staffsList.add(staff));
		
		return new PageImpl<Staff>(staffsList, pageRequest, staffRepository.count());
	}

	@Override
	public Staff getStaff(Long staffId) {
		Staff staff = staffRepository.findById(staffId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"No staff found with ID " + staffId));
		return staff;
	}

	@Override
	public Name getStaffName(Long staffId) {
		return getStaff(staffId).getName();
	}

	
}
