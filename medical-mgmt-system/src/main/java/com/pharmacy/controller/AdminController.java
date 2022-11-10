package com.pharmacy.controller;

import java.lang.constant.Constable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pharmacy.entity.PharmacyItemEntity;
import com.pharmacy.entity.UserEntity;
import com.pharmacy.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
    private  AdminService adminService;
	
	@PostMapping("/saveMedicine")
	public PharmacyItemEntity saveMedicine(@RequestBody PharmacyItemEntity pharmacyItemEntity) {
		
	return adminService.saveMadicine(pharmacyItemEntity);
	}
	
	@DeleteMapping("/deletMedicine")
	public void deleteMedicine(@RequestParam int id) {
		
		adminService.deletMadicine(id);
		
		
	}
	
	@PostMapping("/saveStaff")
	public UserEntity saveStaff(@RequestBody UserEntity userEntity) {
		
		return adminService.saveStaff(userEntity);
		
	}
	
	@DeleteMapping("/deletStaff")
    public String deleteStaff(@RequestParam int id) {
		
		return adminService.deletStaff(id);
	
	}
}
