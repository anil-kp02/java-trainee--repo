package com.watso.invoice.entity;

public class InvoiceItem {

	private String itemName;
	private Integer quantity;
	private Double unitPrice;

	public InvoiceItem(String itemName, int quantity, double unitPrice) {
		this.itemName = itemName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public Double getTotal() {
		return quantity * unitPrice;
	}

	// Getters
	public String getItemName() {
		return itemName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}
	
	// setters 

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	
	
	

}
