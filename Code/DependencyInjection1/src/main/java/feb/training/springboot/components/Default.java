package feb.training.springboot.components;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("default")
@Primary
public class Default implements ModeOfPayment {

	@Override
	public void paymentType() {
		System.out.println("Default Payment enabled");
	}

}
