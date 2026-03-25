package feb.training.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import feb.training.springboot.entities.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long>{

}
