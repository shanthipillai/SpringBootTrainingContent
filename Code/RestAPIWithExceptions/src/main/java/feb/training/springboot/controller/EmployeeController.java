package feb.training.springboot.controller;

import java.net.URI;
import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import feb.training.springboot.entities.Employee;
import feb.training.springboot.exceptions.DuplicateRecordException;
import feb.training.springboot.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.PathItem.HttpMethod;

@RestController
//@Controller
//http://localhost:8080/employees
@RequestMapping("/employees")
@Tag(name = "Employee API", description = "Operations related to users")
public class EmployeeController {

	@Autowired
	EmployeeService empservice;
	/*
	 * //@ResponseBody
	 * 
	 * @GetMapping public String getName() { return
	 * "Welcome Spring Boot Training Madhuri"; }
	 * 
	 * @GetMapping("/getemp") public Employee getEmp() { return new
	 * Employee(1,"Madhuri","Developer", 900000); }
	 * 
	 * @GetMapping("/getallemps") public List<Employee> getAllEmps() {
	 * List<Employee> emplist=new ArrayList<>(); emplist.add(new
	 * Employee(1,"Madhuri","Developer", 900000)); emplist.add(new
	 * Employee(1,"Willaims","Senior Developer", 1900000)); emplist.add(new
	 * Employee(1,"Shanthi","Senior Developer", 1900000)); return emplist;
	 * 
	 * }
	 */

	@GetMapping(value="/genxml", produces = "application/xml")
	
	
	@Operation(
		    summary = "Get all users in XML format",
		    description = "This API retrieves all users from the list."
		)
	
	
	public List<Employee> getEmployeeListToXML()
	{
		return empservice.getAllEmpDetails();
	}
	
	
	@PostMapping
	
	@Operation(
		    summary = "Create Employee",
		    description = "This api is used to create employees."
		)
	
	public Employee createEmployee(@RequestBody Employee emp) {
		
		return empservice.createEmployee(emp);
	}
	
	
	@ExceptionHandler(DuplicateRecordException.class)
	public ResponseEntity<String>  handleDuplicateUserException(DuplicateRecordException ex)
	{
		return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
	}
	
	
	

	//@RequestMapping(value = "/empdetails", method = RequestMethod.GET)
	@GetMapping("/empdetails")
	
	@Operation(
		    summary = "Get All Employees",
		    description = "This api is used to get all employees."
		)
	public List<Employee> getAllEmpDetails() {
		return empservice.getAllEmpDetails();
	}

	@Operation(
		    summary = "Get Employee by Id",
		    description = "This api fetches emp by their id's."
		)
	@GetMapping("{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		
		return empservice.getEmployeeById(id);
	}

	@Operation(
		    summary = "Get RoleBasedEmployees",
		    description = "This api retrieve list of employees having specific role."
		)
	@GetMapping("/getemprolebased")
	public List<Employee> getEmpBasedOnRole(@RequestParam(name = "role") String role) {
		return empservice.getEmpBasedOnRole(role);

	}
	
	@PutMapping("/emp/{id}")
	@Operation(
		    summary = "Update Employee",
		    description = "This api is used to update employee."
		)
	public Employee updateEmployee(@PathVariable("id") int  id, @RequestBody Employee employee)
	{
		return empservice.updateEmployee(id,employee);
	}
	
	@Operation(
		    summary = "Partial Update Employee",
		    description = "This api is used to partial update on employees."
		)
	@PatchMapping("{id}")
	public Employee partialUpdate(@PathVariable("id") int id, @RequestBody Map<String,Object> updates)
	{
		
		System.out.println(id);
		updates.entrySet().forEach(System.out::println);
		//return new Employee(1,"Shanthi", "Dev",90000);
		return empservice.partialUpdate(id,updates);
	}
	
	@Operation(
		    summary = "Delete Employee",
		    description = "This api is used to delete employees."
		)
	@DeleteMapping("{id}")
	public Employee deleteEmployee(@PathVariable int id)
	{
		 return empservice.deleteEmployee(id);
	}
	
	@PostMapping("/responseentity/create")
	public ResponseEntity<Employee> createEntity(@RequestBody Employee employee)
	{
		return empservice.createEntity(employee);
	}
	
	@PostMapping("/requestentity/create")
	public ResponseEntity<String> createRequestEntity(RequestEntity<Employee>  employee)
	{
		Employee emp=employee.getBody();
		org.springframework.http.@Nullable HttpMethod method=employee.getMethod();
		URI uri=employee.getUrl();
		org.springframework.http.HttpHeaders headers=employee.getHeaders();
		
		System.out.println(headers.get("authkey"));
		System.out.println(method);
		System.out.println(uri);
		
		return ResponseEntity.status(HttpStatus.CREATED).header("authkey", "testing")
				.body("Created")
				
				;
	}
	
}