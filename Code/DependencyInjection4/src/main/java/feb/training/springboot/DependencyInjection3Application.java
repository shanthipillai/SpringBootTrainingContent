package feb.training.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import feb.training.springboot.services.OrderSer;



@SpringBootApplication
public class DependencyInjection3Application {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(DependencyInjection3Application.class, args);
		OrderSer service=(OrderSer) context.getBean("order");
		service.placeOrder(5000);
	
	
	}

}
