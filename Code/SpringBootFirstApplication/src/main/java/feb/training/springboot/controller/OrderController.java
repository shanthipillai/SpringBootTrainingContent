package feb.training.springboot.controller;

import org.springframework.stereotype.Component;

@Component
public class OrderController {
	OrderController()
	{
		System.out.println("Order Controller bean is created by container");
	}
}
