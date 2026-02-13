package feb.training.springboot.components;

import org.springframework.stereotype.Component;

@Component("upi")

public class UPI implements ModeOfPayment {

	@Override
	public void paymentType() {
		System.out.println("UPI");

	}

}
