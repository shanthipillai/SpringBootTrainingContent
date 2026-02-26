package feb.training.springboot.diprototypeinsingleton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import feb.training.springboot.diprototypeinsingleton.OrderService;
//import feb.training.springboot.disingletoninproto.Orders;

//import feb.training.springboot.prototype.OrderService;

//import feb.training.springboot.singleton.OrderService;

@SpringBootApplication
public class SpringBeanScopesApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBeanScopesApplication.class, args);
		
		OrderService obj1 = (OrderService) context.getBean("protoinsigl");
		obj1.getDetails();
		OrderService obj2 = (OrderService) context.getBean("protoinsigl");
		obj2.getDetails();


	}

}
