package com.invoice.demo.entity;

public class TenderDetails {
    private double amount;
    private String type;
    
	public TenderDetails(double amount, String type) {
		this.amount = amount;
		this.type = type;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "TenderDetails amount=" + amount + ", type=" + type;
	}
    
}
