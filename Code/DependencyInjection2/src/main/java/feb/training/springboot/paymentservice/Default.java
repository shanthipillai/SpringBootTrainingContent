package feb.training.springboot.paymentservice;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("default")
@Primary
public class Default implements PaymentMode {

	@Override
	public void pay(double amount) {
		System.out.println("Your order has been placed using Card\\nAmount= " + amount);

	}

}
