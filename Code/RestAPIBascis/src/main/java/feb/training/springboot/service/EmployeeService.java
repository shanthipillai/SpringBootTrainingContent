package feb.training.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import feb.training.springboot.entities.Employee;

@Service
public class EmployeeService {
	Employee employee;
	List<Employee> emplist = new ArrayList<>();

	public Employee createEmployee(Employee emp) {
		// TODO Auto-generated method stub
		emplist.add(emp);
		return emp;
	}

	public List<Employee> getAllEmpDetails() {
		// TODO Auto-generated method stub
		return emplist;
	}

	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		// Employee objects
		return emplist.stream()

				// .filter(emp->emp.getId()==id && emp.getRole().equalsIgnoreCase("UI
				// Developer"))
				.filter(emp -> emp.getId() == id).findFirst().get();
	}

	public List<Employee> getEmpBasedOnRole(String role) {

		return emplist.stream().filter(emp -> emp.getRole().equalsIgnoreCase(role)).toList();
	}

	public Employee updateEmployee(int id, Employee employee2) {
		// TODO Auto-generated method stub
		Employee emp = getEmployeeById(id);

		if (emp != null) {
			//employee2.setId(id);
			emp.setId(id);
			emp.setName(employee2.getName());
			emp.setRole(employee2.getRole());
			emp.setSalary(employee2.getSalary());
		} else {
			employee2.setId(id);
			emplist.add(employee2);
			return employee2;
		}

		return emp;

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

	// developer, Developer

}
