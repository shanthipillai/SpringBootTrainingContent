package feb.training.springboot.lazyannotate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("order")
public class OrderService {

	@Autowired
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
