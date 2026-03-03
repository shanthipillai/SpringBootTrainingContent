package feb.training.springboot.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component("card")
public class Card implements PaymentMode {

	@Override
	public void pay(double amount) {
		System.out.println("Paid using card");
	}

}
