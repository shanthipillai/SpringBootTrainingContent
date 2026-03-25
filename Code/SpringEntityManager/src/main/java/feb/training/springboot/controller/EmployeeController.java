package feb.training.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import feb.training.springboot.entity.Employee;
import feb.training.springboot.service.EmployeeService;
import jakarta.persistence.EntityManager;

@RestController
@RequestMapping("/employeeentity")
public class EmployeeController 
{
	@Autowired
	EmployeeService service;
	/*
	 * @PostMapping public Employee createEmployee(@RequestBody Employee emp) {
	 * return service.createEmployee(emp);
	 * 
	 * 
	 * }
	 */
	
	@GetMapping
	public Employee test()
	{
		return service.test();
	}
	
	
	@GetMapping("/getall")
	public List<Employee> getAllEmps()
	{
		return service.getAllEmps();
	}

	@GetMapping("{id}")
	public Employee findById(@PathVariable("id") int id)
	{
		return service.findById(id);
	}
	
	@PostMapping("/transaction")
	public Employee transactionmangt(@RequestBody Employee emp)
	{
		return service.transtransactionmangt(emp);
	}
	
	@PostMapping("/batchinserts")
	public String batchInserts()
	{
		return service.batchInserts();
		
	}
	
}

