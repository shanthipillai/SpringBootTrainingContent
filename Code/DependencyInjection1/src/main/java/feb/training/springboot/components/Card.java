package feb.training.springboot.components;

import org.springframework.stereotype.Component;

@Component("card")
public class Card implements ModeOfPayment {

	@Override
	public void paymentType() {
		System.out.println("Card Payment enabled");

	}

}
