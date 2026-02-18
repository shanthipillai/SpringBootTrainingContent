package feb.training.springboot.orderservice.discount;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;


public interface DiscountSer {
	
	double applyDiscount(double amount);
   }
