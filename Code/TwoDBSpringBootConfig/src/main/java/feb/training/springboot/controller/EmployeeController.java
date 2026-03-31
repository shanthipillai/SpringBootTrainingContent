package feb.training.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import feb.training.springboot.client.entities.Client;
import feb.training.springboot.company.entities.Employee;
import feb.training.springboot.dto.EmployeeClientDTO;
import feb.training.springboot.service.EmployeeService;
@RestController
@RequestMapping("/twodbconfig")
public class EmployeeController {

	@Autowired
	EmployeeService empservice;
	@PostMapping("/newjoinee")
	public Employee postCompanyEmp(@RequestBody Employee emp)
	{
		return empservice.postCompanyEmp(emp);
		
	}
	
	@PostMapping("/newemptoclient")
	public Client postClientEmp(@RequestBody Client client) {
		return empservice.postClientEmp(client);
	}
	@GetMapping("/{id}")
	public EmployeeClientDTO getById(@PathVariable Integer id)
	{
		return empservice.getById(id);
	}
}
