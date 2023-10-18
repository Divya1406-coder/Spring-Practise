package com.invoice.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invoice.demo.entity.Invoice;
import com.invoice.demo.entity.TenderDetails;
import com.invoice.demo.service.InvoiceService;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class InvoiceController {

	// Handle the object creation to spring boot container
	@Autowired
	private InvoiceService service;

	@GetMapping("/customer/{customerId}")
	public Map<Long, String> getInvoices(@PathVariable long customerId) throws Exception {
		// Perform logic to retrieve invoices and tender types based on the customer ID
		Map<Long, String> invoiceMap = new HashMap<>();
		// retriving inid
		List<Invoice> inid = service.getInvoiceId(customerId);

		// retirving tender details
		for (int i = 0;i < inid.size(); i++) {

			Long temp = inid.get(i).getInvoice_id();
			if (temp != null) {
				String td = service.getTenderDetailsByInvoiceId(temp).getType();
				// frame a response in hashmap
				invoiceMap.put(temp, td);
			}
		}

		// handling negative scenario
		if (invoiceMap.size() == 0)
			throw new Exception();

		return invoiceMap;
	}
}
