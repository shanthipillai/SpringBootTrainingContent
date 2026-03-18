package feb.training.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import feb.training.springboot.entities.Customer;
import feb.training.springboot.repo.CustomerRepo;
import jakarta.transaction.Transactional;

@Service
public class CustomerService {
	@Autowired
	CustomerRepo repo;

	public List<Customer> createCustomers(List<Customer> list) {
		return repo.saveAll(list);
		// return null;
	}

	public Customer findByIdid(Integer id) {
		// TODO Auto-generated method stub
		// getbyId
		return repo.findById(id).get();

	}

	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public List<Customer> findByName(String name) {
		// TODO Auto-generated method stub
		return repo.findByName(name);
	}

	public List<Customer> findAllByOrderByNameAsc() {
		// TODO Auto-generated method stub
		return repo.findAllByOrderByNameAsc();
	}

	public List<Customer> findTop3ByOrderBySalaryDesc() {
		// TODO Auto-generated method stub
		return repo.findTop3ByOrderBySalaryDesc();
	}

	public List<Customer> findBySalaryGreaterThan(Double salary) {
		// TODO Auto-generated method stub
		return repo.findBySalaryGreaterThan(salary);
	}

	//@Transactional
	public Customer updateCustomer(Integer id, Customer customer) {
		Customer customerfound = repo.findById(id).get();

		if (customer.getSalary() != null) {
			customerfound.setSalary(customer.getSalary());
		}

		repo.save(customerfound);

		// Optional<Customer> custopt=repo.findById(id);
		return customerfound;
	}

	public List<Customer> sortCustomers(Sort sort) {
		// TODO Auto-generated method stub
		return repo.findAll(sort);
	}

	public Page<Customer> getByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return repo.findAll(pageable);
	}

	public Page<Customer> pageCustDynamically(Pageable pageable) {
		// TODO Auto-generated method stub
		return repo.findAll(pageable);
	}

	
	
	
	

}
