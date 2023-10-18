package com.employee.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	@Autowired
	private NameService nameService;
	
	@GetMapping
	@RequestMapping("/api/employees")
	public Employee getEmployeeDetails() {
		Employee emp = new Employee();
		String name = nameService.callnameservice();
		emp.setName(name);
		emp.setSalary(100);
		return emp;
	}
}
