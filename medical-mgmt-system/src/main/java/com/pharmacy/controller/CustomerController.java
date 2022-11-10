package com.pharmacy.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pharmacy.entity.CustomerEntity;
import com.pharmacy.entity.PharmacyItemEntity;
import com.pharmacy.model.OrderModel;
import com.pharmacy.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/registerCustomer")
	public CustomerEntity saveCustomer(@RequestBody CustomerEntity customerEntity) {
		return customerService.saveCustomer(customerEntity);
	}
	
	@GetMapping("/searchProducts")
	public List<PharmacyItemEntity> searchProducts(@RequestParam String searchString ){
		return customerService.searchProducts(searchString);
		
	}
	
	@PostMapping("/purchaseItem")
	public String purchaseItem(@RequestBody OrderModel order) {
		return customerService.savePurhase(order);

		
	}
	
	@GetMapping(value = "/generateReceipt")
	public List<Map<String, Object>> generateReceipt(@RequestParam int custId) {
		return customerService.generateReceipt(custId);
	}
	
	
}


