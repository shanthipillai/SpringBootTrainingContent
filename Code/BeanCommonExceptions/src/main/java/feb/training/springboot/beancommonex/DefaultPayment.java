package feb.training.springboot.beancommonex;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("cards")
//@Primary
public class DefaultPayment implements PaymentService {

	@Override
	public void pay() {
		System.out.println("Paid through cash");

	}

}
