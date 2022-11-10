package com.pharmacy.service;

import java.lang.constant.Constable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.entity.PharmacyItemEntity;
import com.pharmacy.entity.UserEntity;
import com.pharmacy.repository.PharamacyItemRepo;
import com.pharmacy.repository.UserRepo;

@Service
public class AdminService {
	@Autowired
    private PharamacyItemRepo pharamacyItemRepo;
	
	@Autowired
	private UserRepo UserRepo;


	public PharmacyItemEntity saveMadicine(PharmacyItemEntity pharmacyItemEntity) {
		return pharamacyItemRepo.save(pharmacyItemEntity);
		
		// TODO Auto-generated method stub
		
	}


	public String deletMadicine(int id) {
		pharamacyItemRepo.deleteById(id);
		return "medicine deleted";
		// TODO Auto-generated method stub
		
	}


	public UserEntity saveStaff(UserEntity userEntity) {
		return UserRepo.save(userEntity);
		// TODO Auto-generated method stub
		
	}


	public String deletStaff(int id) {
		UserRepo.deleteById(id);
		return "Staff deleted";

		// TODO Auto-generated method stub
		
	}
	
	

}
