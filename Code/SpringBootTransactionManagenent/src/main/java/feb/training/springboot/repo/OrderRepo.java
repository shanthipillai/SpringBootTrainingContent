package feb.training.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import feb.training.springboot.entities.OrderTrans;

public interface OrderRepo extends JpaRepository<OrderTrans, Integer> {

}
