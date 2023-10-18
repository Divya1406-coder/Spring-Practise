package com.invoice.demo.entity;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "invoice")
public class Invoice {
	@Field("customer_id")
	private long customer_id;

	@Field("invoice_id")
	private long invoice_id;

	@DBRef
	@Field("invoice_data")
	private InvoiceData invoice_data;

	public Invoice(int customer_id, int invoice_id, InvoiceData invoice_data) {
		this.customer_id = customer_id;
		this.invoice_id = invoice_id;
		this.invoice_data = invoice_data;
	}

	public long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}

	public long getInvoice_id() {
		return invoice_id;
	}

	public void setInvoice_id(long invoice_id) {
		this.invoice_id = invoice_id;
	}

	public InvoiceData getInvoice_data() {
		return invoice_data;
	}

	public void setInvoice_data(InvoiceData invoice_data) {
		this.invoice_data = invoice_data;
	}

	@Override
	public String toString() {
		return "Invoice customer_id=" + customer_id + ", invoice_id=" + invoice_id + ", invoice_data=" + invoice_data;
	}

}
