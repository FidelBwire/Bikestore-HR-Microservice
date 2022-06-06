package com.app.bikestore.staffs.controller;

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

import com.app.bikestore.common.Name;
import com.app.bikestore.staffs.entity.Staff;
import com.app.bikestore.staffs.service.StaffService;

@RestController
@RequestMapping(value = "/hr/staffs")
@CrossOrigin(origins = "http://localhost:4200")
public class StaffController {

	@Autowired
	private StaffService staffService;
	
	@GetMapping
	public ResponseEntity<Page<Staff>> getStaffs(
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size) {
		Page<Staff> staffs = staffService.getStaffs(page, size);
		return new ResponseEntity<Page<Staff>>(staffs, HttpStatus.OK);
	}
	
	@GetMapping("/{staffId}")
	public ResponseEntity<Staff> getStaff(@PathVariable Long staffId) {
		Staff staff = staffService.getStaff(staffId);
		return new ResponseEntity<Staff>(staff, HttpStatus.OK);
	}
	
	@GetMapping("/{staffId}/name")
	public ResponseEntity<Name> getStaffName(@PathVariable Long staffId) {
		Name name = staffService.getStaffName(staffId);
		return new ResponseEntity<Name>(name, HttpStatus.OK);
	}
}
