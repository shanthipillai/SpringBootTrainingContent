package feb.training.springboot.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

	OrderService()
	{
		System.out.println("Order Service bean created by container");
	}
}
