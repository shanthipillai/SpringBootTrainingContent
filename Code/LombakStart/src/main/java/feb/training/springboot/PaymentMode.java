package feb.training.springboot;

import org.springframework.stereotype.Component;

@Component
public class PaymentMode {
	//Constructor
	public PaymentMode()
	{
		System.out.println("Only payment mode enabled");
	}
	
	//Instance Method
	public void paid()
	{
		System.out.println("Done the payment");
	}
	
}
