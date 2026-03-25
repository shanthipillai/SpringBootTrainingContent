package feb.training.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import feb.training.springboot.entities.Employee;
import feb.training.springboot.repo.EmployeeRepo;

@Service
public class EmployeeService {
    @Autowired
	EmployeeRepo repo;
    
	public Employee createEmployee(Employee employee) {
		System.out.println(employee);
	    employee.getProfile().setEmployee(employee);
		
	   
	  
		return repo.save(employee);
	}

	public void deleteEmployee(Long empid) {
		repo.deleteById(empid);
		
	}

	public Employee patchEmployee(Long empid, Employee emp) {
		Employee empbyid=repo.getById(empid);
	if(	emp.getYearsofexperience()!=null)
	{
		empbyid.setYearsofexperience(emp.getYearsofexperience());
		
	}
	
	if(emp.getProfile()!=null)
	{
	if(	emp.getProfile().getMobile()!=null)
	{
		empbyid.getProfile().setMobile(emp.getProfile().getMobile());
	}
	}
		return empbyid;
	}

	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
