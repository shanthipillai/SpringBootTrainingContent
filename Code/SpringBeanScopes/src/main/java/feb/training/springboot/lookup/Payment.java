package feb.training.springboot.lookup;

import org.springframework.stereotype.Component;

@Component
public class Payment {
	public Payment()
	{
		System.out.println("Payment service"+this.hashCode());
	}

	public void pay() {
		System.out.println("Paid");
		
	}
}
