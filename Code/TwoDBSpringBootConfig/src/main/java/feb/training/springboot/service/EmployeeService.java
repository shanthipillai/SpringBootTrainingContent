package feb.training.springboot.service;

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
	public EmployeeClientDTO getById(Integer id) {
		Employee emp=companyrepo.findById(id).get();
		dto.setEmpid(emp.getEmpid());
		dto.setEmpemail(emp.getEmpemail());
		dto.setCompanyexp(emp.getCompanyexp());
		dto.setBilling(emp.getBilling());
		 Client client = clientrepo.findByEmpid(id);
		 dto.setClientemail(client.getClientemail());
		 dto.setClientexp(client.getClientexp());
		 dto.setClientid(client.getClientid());
		 dto.setPrjctname(emp.getPrjctname());
		 return dto;
		
	}

}
