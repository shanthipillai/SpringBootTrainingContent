package feb.training.springboot.paymentservice;

import org.springframework.stereotype.Service;

@Service("cards")
public class Card implements PaymentMode {

	@Override
	public void pay(double amount) {
		System.out.println("Your order has been placed using Card \\nAmount= "+amount);
		
	}

}
