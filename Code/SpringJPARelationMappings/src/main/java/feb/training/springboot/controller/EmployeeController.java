package feb.training.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import feb.training.springboot.entities.Employee;
import feb.training.springboot.service.EmployeeService;

@RestController
@RequestMapping("/infiservices")
public class EmployeeController {
 
	@Autowired
	EmployeeService employeeService;
	
	
	@PostMapping("/create_employees")
	public Employee createEmployee(@RequestBody Employee employee)
	{
		//return employeeService.createEmployee(employee);
		return employeeService.createEmployee(employee);
	}
	 @DeleteMapping("/delete_employee")
	public void deleteEmployee(@RequestParam Long empid)
	{
		 employeeService.deleteEmployee(empid);
	}
	 
	 @PatchMapping("/merge_employee/{empid}")
	 public Employee patchEmployee(@PathVariable Long empid,@RequestBody Employee emp )
	 {
		 return employeeService.patchEmployee(empid,emp);
	 }
	 
	 @GetMapping("/get_allemps")
	 public List<Employee> getAllEmployees()
	 {
		 return employeeService.getAllEmployees();
	 }
	 
}
