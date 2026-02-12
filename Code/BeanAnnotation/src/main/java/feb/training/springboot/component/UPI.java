package feb.training.springboot.component;

import org.springframework.stereotype.Component;

//@Component
public class UPI implements ModeOfPayment {
	UPI()
	{
		System.out.println("UPI Mode Enabled");
	}
	@Override
	public void modeOfPayment() {
		System.out.println("UPI payment is enabled");
		
	}

}
