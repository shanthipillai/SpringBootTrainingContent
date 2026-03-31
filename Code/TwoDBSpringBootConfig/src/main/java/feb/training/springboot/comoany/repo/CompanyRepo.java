package feb.training.springboot.comoany.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import feb.training.springboot.client.entities.Client;
import feb.training.springboot.company.entities.Employee;
@Repository
public interface CompanyRepo extends JpaRepository<Employee, Integer> {

}
