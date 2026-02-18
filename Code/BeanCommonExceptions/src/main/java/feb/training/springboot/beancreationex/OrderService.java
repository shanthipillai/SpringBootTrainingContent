package feb.training.springboot.beancreationex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
@Service("order")
public class OrderService {
	
	PaymentService payservice;
	
	@PostConstruct
	public void init() {
	    int x = 10 / 0;  //Arithmetic exception
	}
	
	public OrderService()
	{
		System.out.println("Order Service Created");
	}
	@Autowired
	public OrderService(@Qualifier("cards")   PaymentService payservice) {
		super();
		this.payservice = payservice;
	}
	
	
	public void printReceipt()
	{
		payservice.pay();
	}
	
}
