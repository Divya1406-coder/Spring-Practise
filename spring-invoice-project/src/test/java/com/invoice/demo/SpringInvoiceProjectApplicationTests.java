package com.invoice.demo;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.invoice.demo.controller.InvoiceController;
import com.invoice.demo.entity.Invoice;
import com.invoice.demo.entity.TenderDetails;
import com.invoice.demo.service.InvoiceService;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
class InvoiceControllerTest {

	@Mock
	private InvoiceService invoiceService;

	@InjectMocks
	private InvoiceController invoiceController;
	
	@Autowired
    private MockMvc mockMvc;
	
	public InvoiceControllerTest() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetTenderDetailsByCustomerId() throws Exception {
		long customerId = 1;

		// Create sample tender details
		Map<Long, String> expectedTenderDetails = new HashMap<>();
		TenderDetails td = new TenderDetails(23.43, "cash");
		expectedTenderDetails.put(54L, "cash");

		// Mock the tenderService to return the expected tender details
		when(invoiceService.getTenderDetailsByInvoiceId(anyLong())).thenReturn(td);

		// Call the controller method
		Map<Long, String> actualTenderDetails = invoiceController.getInvoices(customerId);

		// Verify the result
		assertEquals(expectedTenderDetails, actualTenderDetails);
	}

	@Test
	public void testGetInvoicesByCustomerId_InvalidCustomerId() throws Exception {
		long customerId = 12345L;

		// Mock the service method to throw an exception
		when(invoiceService.getInvoiceId(anyLong())).thenThrow(new Exception());

		// Perform the request
		mockMvc.perform(MockMvcRequestBuilders.get("/api/customers/{customerId}/invoices", customerId)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isNotFound())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$.status").value(HttpStatus.NOT_FOUND.value()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Customer ID not found"));
	}
}
