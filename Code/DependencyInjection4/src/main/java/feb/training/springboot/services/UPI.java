package feb.training.springboot.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("upi")
@Primary
public class UPI implements PaymentMode {

	@Override
	public void pay(double amount) {
		// TODO Auto-generated method stub

	}

}
