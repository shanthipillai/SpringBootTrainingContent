package feb.training.springboot.component;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

@Component
//@ConditionalOnBean
public class Card implements ModeOfPayment {
	Card()
	{
		System.out.println("Card payment enabled");
	}

	@Override
	public void modeOfPayment() {
		// TODO Auto-generated method stub

	}

}
