package feb.training.springboot.payment;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UPI implements PaymentMode {

	@Override
	public void pay(double amount) {
		//System.out.println("Payment done by UPI");
		log.info("UPI Mode Selected");
		log.debug("Payment done throught UPI");
	}

}
