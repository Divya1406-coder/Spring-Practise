package com.invoice.demo.entity;

public class InvoiceData {
	private double time;
	private TenderDetails tenderDetails;
	private String storeNumber;

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public TenderDetails getTenderDetails() {
		return tenderDetails;
	}

	public void setTenderDetails(TenderDetails tenderDetails) {
		this.tenderDetails = tenderDetails;
	}

	public String getStoreNumber() {
		return storeNumber;
	}

	public void setStoreNumber(String storeNumber) {
		this.storeNumber = storeNumber;
	}

	@Override
	public String toString() {
		return "Invoice_data time=" + time + ", tenderDetails=" + tenderDetails + ", storeNumber=" + storeNumber;
	}
	

}
