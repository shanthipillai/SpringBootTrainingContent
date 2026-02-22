package feb.training.springboot.services;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component("payment")
public class PaymentService {
	PaymentService()
	{
		System.out.println("Payment service initiated"+this.hashCode());
	}
	
}
