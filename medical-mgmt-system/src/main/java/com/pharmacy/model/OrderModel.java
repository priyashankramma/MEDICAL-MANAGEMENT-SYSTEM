package com.pharmacy.model;

public class OrderModel {
	
	private int customerId;
	private String category;
	private String itemName;
	private int quantity;
	private int medicineId;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCateegory() {
		return category;
	}
	public void setCateegory(String cateegory) {
		this.category = cateegory;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}
	
	
	

}
