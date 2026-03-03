package feb.training.springboot.lazyannotate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import feb.training.springboot.diprototypeinsingleton.PaymentService;
import jakarta.annotation.PostConstruct;

@Component("order")
public class OrderService {

	@Autowired
	@Lazy
	private Payment payment;
	public OrderService()
	{
		System.out.println("Order Service created"+this.hashCode());
		System.out.println("Payment Service"+payment);
	}
	


	
	public void getDetails()
	{
		payment.pay();
	}
}
