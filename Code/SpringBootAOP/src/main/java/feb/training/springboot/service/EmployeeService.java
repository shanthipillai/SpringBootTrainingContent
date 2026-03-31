package feb.training.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import feb.training.springboot.client.entities.Client;
import feb.training.springboot.client.repo.ClientRepo;
import feb.training.springboot.comoany.repo.CompanyRepo;
import feb.training.springboot.company.entities.Employee;
import feb.training.springboot.dto.EmployeeClientDTO;

@Service
public class EmployeeService {

	@Autowired
	CompanyRepo companyrepo;
	@Autowired
	ClientRepo clientrepo;
	@Autowired
	EmployeeClientDTO dto;

	public Employee postCompanyEmp(Employee emp) {
		companyrepo.save(emp);
		
		return emp;

	}

	public Client postClientEmp(Client client) {
		// TODO Auto-generated method stub
		clientrepo.save(client);
		return client;
	}
	//Proxy Add

	public EmployeeClientDTO getById(Integer id) {
		System.out.println("Printing you id info" + id);
		Optional<Employee> empop = companyrepo.findById(id);
		
		 if (empop.isEmpty()) {
		        throw new RuntimeException("Employee not found with id: " + id);
		    }
		 else {

			 
		Employee emp=empop.get();
		System.out.println("Employee INFO" + emp.getEmpid());

		dto.setEmpid(emp.getEmpid());
		dto.setEmpemail(emp.getEmpemail());
		dto.setCompanyexp(emp.getCompanyexp());
		dto.setBilling(emp.getBilling());
		 dto.setPrjctname(emp.getPrjctname());

		
		  Client client = clientrepo.findByEmpid(id);
		  //System.out.println("Client Info");
		  //System.out.println(client.getClientid());
		  
		  dto.setClientemail(client.getClientemail());
		  dto.setClientexp(client.getClientexp());
		  dto.setClientid(client.getClientid()); 
		 }
		 
		return dto;

	}

}
