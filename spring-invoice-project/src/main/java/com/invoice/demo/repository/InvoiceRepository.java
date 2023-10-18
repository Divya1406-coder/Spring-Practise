package com.invoice.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.invoice.demo.entity.Invoice;

public interface InvoiceRepository extends MongoRepository<Invoice, Long> {

	List<Invoice> findAllById(long customer_id);
	
	@Query("{'invoice_id': ?0}")
	Optional<Invoice> findByInvoiceId(Long invoice_id);
}
