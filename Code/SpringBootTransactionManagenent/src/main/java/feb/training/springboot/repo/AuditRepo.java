package feb.training.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import feb.training.springboot.entities.Audit;

public interface AuditRepo extends JpaRepository<Audit, Integer> {

}
 