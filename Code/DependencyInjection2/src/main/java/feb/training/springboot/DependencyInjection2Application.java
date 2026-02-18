package feb.training.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;

import feb.training.springboot.orderservice.OrderService;

@SpringBootApplication
public class DependencyInjection2Application {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(DependencyInjection2Application.class, args);
		OrderService order= (OrderService) context.getBean("order");
		order.placeOrder(5000);
	}

}
