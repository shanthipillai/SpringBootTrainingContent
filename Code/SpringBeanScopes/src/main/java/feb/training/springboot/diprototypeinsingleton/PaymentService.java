package feb.training.springboot.diprototypeinsingleton;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PaymentService {
	
	public void pay() {
       System.out.println("Payment Object Created"+this.hashCode());
	}
}
