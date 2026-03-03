package order.services;

import org.springframework.stereotype.Component;

@Component
public class Orders {
	
	public Orders() {
		System.out.println("Welcome to Order Service");
	}
	public void placeOrder()
	{
		System.out.println("You order has been placed");
	}

}
