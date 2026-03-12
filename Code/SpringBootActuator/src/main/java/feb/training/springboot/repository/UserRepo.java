package feb.training.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import feb.training.springboot.entity.User;
@Repository
public interface UserRepo extends JpaRepository<User, String> {

}
