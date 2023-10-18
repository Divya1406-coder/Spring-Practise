package com.registration.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.registration.entity.User;
import com.registration.entity.UserRegistrationRequest;
import com.registration.repository.UserRepository;


@RestController
public class UserController {
	private UserRepository userRepository  = new UserRepository();
	@Autowired
	private MessageSource messageSource;
	
	
	@GetMapping("/")
	public String ping() {
		return "Success";
	}

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody UserRegistrationRequest request) {
		try {
			User user = new User();
			user.setFirstName(request.getFirstName());
			user.setLastName(request.getLastName());
			user.setAddress(request.getAddress());
			if(isValidCanadianPostalCode(user.getAddress().getPostalCode())){
				userRepository.save(user);
				Locale locale = LocaleContextHolder.getLocale();
				String successMessage = messageSource.getMessage("registration.success.message", null, locale);
				return ResponseEntity.ok(successMessage);
			}
			throw new Exception();
		} catch (Exception e) {
			Locale locale = LocaleContextHolder.getLocale();
			
			String errorMessage = messageSource.getMessage("registration.error.message", null, locale);
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		}
	}

	private boolean isValidCanadianPostalCode(String postalCode) {
		String postalCodePattern = "^[ABCEGHJKLMNPRSTVXY][0-9][ABCEGHJKLMNPRSTVWXYZ] [0-9][ABCEGHJKLMNPRSTVWXYZ][0-9]$";
		return postalCode.matches(postalCodePattern);
	}
}
