package feb.training.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import feb.training.springboot.entities.PaymentTrans;

public interface PaymentRepo extends JpaRepository<PaymentTrans, Integer> {

}
