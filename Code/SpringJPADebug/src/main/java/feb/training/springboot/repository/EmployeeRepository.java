package feb.training.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import feb.training.springboot.emtity.Employee;

public interface EmployeeRepository
extends JpaRepository<Employee, Long> {
}