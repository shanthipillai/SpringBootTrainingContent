package feb.training.springboot;

import org.springframework.stereotype.Component;

@Component
public class PaymentMode {
	
	public PaymentMode()
	{
		System.out.println("Only payment mode enabled");
	}
	
	public void paid()
	{
		System.out.println("Done the payment");
	}
	
}
