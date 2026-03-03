package feb.training.springboot.disingletoninproto;

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
		
		Orders order1=context.getBean(Orders.class);
		Orders order2=context.getBean(Orders.class);
		


	}

}
