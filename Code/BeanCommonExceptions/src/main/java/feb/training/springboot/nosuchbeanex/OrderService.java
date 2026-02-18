package feb.training.springboot.nosuchbeanex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("order")
public class OrderService {
	
	PaymentService payservice;
	public OrderService()
	{
		System.out.println("Order Service Created");
	}
	@Autowired
	public OrderService(PaymentService payservice) {
		super();
		this.payservice = payservice;
	}
	
	
	public void printReceipt()
	{
		payservice.pay();
	}
	
}
