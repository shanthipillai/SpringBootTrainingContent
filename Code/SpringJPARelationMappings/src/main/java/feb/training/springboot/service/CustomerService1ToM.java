package feb.training.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import feb.training.springboot.entities.Customer;
import feb.training.springboot.entities.FixedDeposits;
import feb.training.springboot.repo.CustomerRepo;

@Service
public class CustomerService1ToM {

	@Autowired
	CustomerRepo repo;

	public Customer createCustomer(Customer customer) {

	for(FixedDeposits fd:	customer.getFixeddeposits())
	{
		fd.setCustomer(customer);
	}
		return repo.save(customer);

	}

	public void deleteCustomer(Long customerid) {
		// TODO Auto-generated method stub
		repo.deleteById(customerid);
	}

	public List<Customer> getAllCustomers() {
		
		return repo.findAll();
	}

}
