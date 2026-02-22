package feb.training.springboot.services;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("orderscope")
@Scope("singleton")
public class OrderService {
	OrderService()
	{
		System.out.println("Order Service Initiated" +this.hashCode());
	}
}
