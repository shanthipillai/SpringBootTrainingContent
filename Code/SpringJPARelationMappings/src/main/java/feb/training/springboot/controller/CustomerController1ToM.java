package feb.training.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import feb.training.springboot.entities.Customer;
import feb.training.springboot.service.CustomerService1ToM;

@RestController
@RequestMapping("/infiservices")
public class CustomerController1ToM {
    @Autowired
	CustomerService1ToM customerservice;
	
    @PostMapping("/create_customer")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer)
	{
		Customer customercreated =customerservice.createCustomer(customer);
		 return ResponseEntity.status(HttpStatus.CREATED)
				 .body(customercreated);
		
	}
	
	@DeleteMapping("/delete_customer")
	public ResponseEntity<Void> deleteCustomer(@RequestParam Long customerid)
	{
		customerservice.deleteCustomer(customerid);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping("/get_all")
	
	public ResponseEntity<List<Customer>> getAllCustomers()
	{
		List<Customer> list=customerservice.getAllCustomers();
		return ResponseEntity.status(HttpStatus.OK)
				.body(list);
		
	}
	
}
