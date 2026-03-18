package feb.training.springboot.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import feb.training.springboot.entities.Customer;
import feb.training.springboot.service.CustomerService;

@RestController
@RequestMapping("/hdfc")
public class CustomerController {
	@Autowired
	CustomerService service;
	@PostMapping("/createcustomers")
	public List<Customer> createCustomers(@RequestBody List<Customer> list)
	{
		return service.createCustomers(list);
	}
	
	@GetMapping("/getallcustomers")
	public List<Customer> getAll()
	{
		return service.getAll();
	}
	
	@GetMapping("/findbyid")
	public Customer findById(@RequestParam Integer id)
	{
		return service.findByIdid(id);
	}
	
	@GetMapping("/findByName")
	public List<Customer> findByName(@RequestParam String name)
	{
		return service.findByName(name);
	}
	

	@GetMapping("/findAllByOrderByNameAsc")
	public List<Customer> findAllByOrderByNameAsc()
	{
		return service.findAllByOrderByNameAsc();
	}
	
	
	
	

	@GetMapping("/findTop3ByOrderBySalaryDesc")
	public List<Customer> findTop3ByOrderBySalaryDesc()
	{
		return service.findTop3ByOrderBySalaryDesc();
	}
	
	

	@GetMapping("/findBySalaryGreaterThan")
	public List<Customer> findBySalaryGreaterThan(@RequestParam Double salary)
	{
		return service.findBySalaryGreaterThan(salary);
	}
	
	
	@PatchMapping("/partialupdate/{id}")
	public Customer updateCustomer(@PathVariable Integer id, @RequestBody Customer customer)
	{
		return service.updateCustomer(id,customer);
	}
	
	
	@GetMapping("/sortcustomers")
	public List<Customer> sortCustomers(Sort sort)
	{
		
		return service.sortCustomers(sort);
	}
	
	@GetMapping("/getbypagerealtime")
	public Page<Customer> getByPage(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size)
	{
		Pageable pageable=PageRequest.of(page-1, size);
		return service.getByPage(pageable);
	}
	
	@GetMapping("/getpage")
	public Page<Customer> pageCustDynamically(@RequestParam int page)
	{
		Pageable pageable=PageRequest.of(page-1, 2);
		return service.pageCustDynamically(pageable);
	}
}
