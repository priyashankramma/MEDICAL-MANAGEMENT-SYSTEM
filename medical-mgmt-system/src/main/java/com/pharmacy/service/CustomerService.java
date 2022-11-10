
package com.pharmacy.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.entity.CustomerEntity;
import com.pharmacy.entity.OrdersEntity;
import com.pharmacy.entity.PharmacyItemEntity;
import com.pharmacy.model.OrderModel;
import com.pharmacy.repository.CustomerRepo;
import com.pharmacy.repository.OrdersRepo;
import com.pharmacy.repository.PharamacyItemRepo;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private PharamacyItemRepo pharamacyItemRepo;
	
	@Autowired
	private OrdersRepo orderRepo;
	
	
	public CustomerEntity saveCustomer(CustomerEntity customerEntity) {
		// TODO Auto-generated method stub
		return customerRepo.save(customerEntity);
	}

	public List<PharmacyItemEntity> searchProducts(String searchString) {
		return pharamacyItemRepo.findByCategory(searchString);
	}

	public String savePurhase(OrderModel order) {
		//LocalDateTime ld=new LocalDateTime();
		String resp=null;
		Date d=new Date();
		
		Optional<CustomerEntity> ce =customerRepo.findById(order.getCustomerId());
		PharmacyItemEntity pe =pharamacyItemRepo.findById(order.getMedicineId()).get();
		System.out.println("pe...."+pe);
		int mPrize= pe.getPrize();
		int totalPrize=order.getQuantity()*mPrize;
		
		OrdersEntity oe=new OrdersEntity();
		oe.setCustomer(ce.get());
		oe.setMedicine(pe);
		oe.setPrize(totalPrize);
		oe.setQuantity(order.getQuantity());
		oe.setPurchaseDate(d);
		
		OrdersEntity savedEntity=orderRepo.save(oe);
		if(savedEntity!=null)
			resp="Your Order has been Confirmed";
		else
			resp="Some Problem!!couldn't save your order";
		// TODO Auto-generated method stub
		return resp;
	}

	public List<Map<String, Object>> generateReceipt(int custId) {
		List<Map<String,Object>> resp=new ArrayList<>();
		try {
		int totalCost=0;
		List<OrdersEntity> orders=orderRepo.findAllByCustomerId(custId);
		if(orders.size()==0) {
			Map<String,Object> map=new HashMap<>();
			map.put("Error!", "Customer has not made any purchase");
			resp.add(map);
			return resp;
		}
		
		for(OrdersEntity order:orders) {
			Map<String,Object> receipt=new HashMap<>();
			String item=order.getMedicine().getMedicineName();
			int prize=order.getMedicine().getPrize();
			int quantity = Integer.parseInt(order.getMedicine().getQuantity());
			
			receipt.put("Item Name", item);
			receipt.put("prize", prize);
			receipt.put("quantity", quantity);
			resp.add(receipt);
			totalCost=prize*quantity;
		}
		
		Map<String,Object> receipt=new HashMap<>();
		receipt.put("TotalCost", totalCost);
		resp.add(receipt);
		}
		catch(Exception e) {
			Map<String,Object> map=new HashMap<>();
			map.put("Error!", "Some Exception Occured");
			resp.add(map);
		}
		
		
		return resp;
	}

}
