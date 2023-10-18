package com.invoice.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoice.demo.entity.Invoice;
import com.invoice.demo.entity.TenderDetails;
import com.invoice.demo.repository.InvoiceRepository;

@Service
public class InvoiceService {
	@Autowired
    private InvoiceRepository invoiceRepository;
	

    public TenderDetails getTenderDetailsByInvoiceId(Long invoice_id) {
        if(invoiceRepository.findByInvoiceId(invoice_id).get() != null) {
        	return invoiceRepository.findByInvoiceId(invoice_id).get().getInvoice_data().getTenderDetails();
        }
        return null;
    }


	public List<Invoice> getInvoiceId(long customer_id) {
		if(invoiceRepository.findById(customer_id).get() != null) {
			List<Invoice> list = invoiceRepository.findAllById(customer_id);
			return list;
		}
		return null;
	}
	
	
}

