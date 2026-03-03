package feb.training.springboot.lazyannotate;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import feb.training.springboot.diprototypeinsingleton.PaymentService;
import jakarta.annotation.PostConstruct;

@Component
//@Lazy
public class Payment {
	public Payment()
	{
		System.out.println("Payment object created"+this.hashCode());
	}
	
	
	public void pay() {
	System.out.println("Payment done");
		
	}
}
