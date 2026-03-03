package feb.training.springboot.payment;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Primary
public class Default implements PaymentMode {

	@Override
	public void pay(double amount) {
		//System.out.println("Payment done by UPI");
		log.info("Default Mode Selected");
		log.debug("Payment done throught Default");

	}

}
