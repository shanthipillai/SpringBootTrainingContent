package feb.training.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import feb.training.springboot.entity.Employee;
import feb.training.springboot.service.EmployeeService;

@RestController
@RequestMapping("entitylifecycle")
public class EmployeeController {
    @Autowired
	EmployeeService service;
    
    @PostMapping
	public Employee createEmployee()
	{
		return service.createEmployee();
	}
}
