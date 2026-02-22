package feb.training.springboot.services;

import org.springframework.stereotype.Component;

@Component("default")
public class Default implements PaymentMode {

	@Override
	public void pay(double amount) {
		// TODO Auto-generated method stub

	}

}
