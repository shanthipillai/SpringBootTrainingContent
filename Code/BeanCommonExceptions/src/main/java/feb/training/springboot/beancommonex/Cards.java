package feb.training.springboot.beancommonex;

import org.springframework.stereotype.Service;

@Service("cards")
public class Cards implements PaymentService {

	@Override
	public void pay() {
		System.out.println("Paid using card");

	}

}
