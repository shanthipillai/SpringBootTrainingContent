package feb.training.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import feb.training.springboot.entities.Employee;

import feb.training.springboot.exceptions.DuplicateRecordException;
import feb.training.springboot.exceptions.UserNotFoundException;


@Service
public class EmployeeService {
	Employee employee;
	List<Employee> emplist = new ArrayList<>();

	public Employee createEmployee(Employee emp) {
		boolean exists=emplist.stream().anyMatch(e->e.getId()==emp.getId());
		
		if(exists)
		{
			throw new DuplicateRecordException("Employee already exists");
		}
		else
		{
		emplist.add(emp);
		}
		
		return emp;
	}
	
	

	public List<Employee> getAllEmpDetails() {
		// TODO Auto-generated method stub
		return emplist;
	}

	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		// Employee objects
		
		return emplist.stream().filter(emp -> emp.getId() == id).findFirst()
		.orElseThrow(()->new UserNotFoundException("Employee Not Found"));
		
		
	}

	public List<Employee> getEmpBasedOnRole(String role) {

		return emplist.stream().filter(emp -> emp.getRole().equalsIgnoreCase(role)).toList();
	}

	public Employee updateEmployee(int id, Employee employee2) {
		// TODO Auto-generated method stub
		Employee emp = getEmployeeById(id);

		if (emp != null) {
			//employee2.setId(id);
			//emp.setId(id);
			emp.setName(employee2.getName());
			emp.setRole(employee2.getRole());
			emp.setSalary(employee2.getSalary());
			return emp;
		} else {
			employee2.setId(id);
			emplist.add(employee2);
			return employee2;
		}

		

	}

	public Employee partialUpdate(int id, Map<String, Object> updates) {

		Employee emp = getEmployeeById(id);
		if (updates.containsKey("name")) {
			emp.setName((String) updates.get("name"));

		}

		if (updates.containsKey("role"))

		{
			System.out.println("Is value modified here");
			emp.setRole((String) updates.get("role"));
		}

		if (updates.containsKey("salary")) {
			emp.setSalary((double) updates.get("salary"));
		}

		return emp;
	}

	public Employee deleteEmployee(int id) {
	
		Employee emp=getEmployeeById(id);
		emplist.remove(emp);
		return emp;
		
	}

	public ResponseEntity<Employee> createEntity(Employee employee2) {
		emplist.add(employee2);
		return ResponseEntity.status(HttpStatus.CREATED)
				.header("authkey", "testing")
				.body(employee2);
	}

	// developer, Developer

}
