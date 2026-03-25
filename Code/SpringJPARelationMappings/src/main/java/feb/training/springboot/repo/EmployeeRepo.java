package feb.training.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import feb.training.springboot.entities.Employee;



public interface EmployeeRepo extends JpaRepository<Employee, Long>{

}
