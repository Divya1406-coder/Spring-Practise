package com.value.annotation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/api/accounts/{accountId}")
	public ResponseEntity<Account> getAccounts(@PathVariable("accountId") int accountId){
		Account account = new Account();
		account.setAccoutId(accountId);
		account.setName("Kanniraj");
		
		if(accountId == 1) {
			throw new IllegalArgumentException();
		}
		return new ResponseEntity<Account>(account,HttpStatus.OK); 
	}
	
}
