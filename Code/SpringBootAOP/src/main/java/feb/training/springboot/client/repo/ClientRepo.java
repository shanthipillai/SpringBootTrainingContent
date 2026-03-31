package feb.training.springboot.client.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import feb.training.springboot.client.entities.Client;
import feb.training.springboot.company.entities.Employee;
@Repository
public interface ClientRepo extends JpaRepository<Client, Integer> {

	Client findByEmpid(Integer id);

}
