package feb.training.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import feb.training.springboot.entities.User;
@Repository
public interface UserRoleRepo extends JpaRepository<User, Integer> {

}
