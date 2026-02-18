package feb.training.springboot.nosuchbeanex;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//@Service("default")
//@Primary
public class DefaultPayment implements PaymentService {

	@Override
	public void pay() {
		System.out.println("Paid through cash");

	}

}
