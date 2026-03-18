package feb.training.springboot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import feb.training.springboot.entities.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	//select * from customerjpa where name="";
	
	public List<Customer> findByName(String name);
	public List<Customer> findAllByOrderByNameAsc();
	public List<Customer> findTop3ByOrderBySalaryDesc();
	public List<Customer> findBySalaryGreaterThan(Double salary);
}
