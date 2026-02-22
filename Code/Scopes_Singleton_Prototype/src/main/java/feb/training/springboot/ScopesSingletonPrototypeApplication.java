package feb.training.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import feb.training.springboot.services.prototypeinsingleton.OrderService;



@SpringBootApplication
public class ScopesSingletonPrototypeApplication {

	public static void main(String[] args) {
		
		  ApplicationContext context=SpringApplication.run(ScopesSingletonPrototypeApplication.class,args); 
			/*
			 * OrderService order1=(OrderService) context.getBean("orderscope");
			 * OrderService order2=(OrderService) context.getBean("orderscope");
			 * 
			 * System.out.println(order1); System.out.println(order2);
			 * 
			 * PaymentService pay1=(PaymentService) context.getBean("payment");
			 * PaymentService pay2=(PaymentService) context.getBean("payment");
			 * System.out.println(pay1); System.out.println(pay2);
			 * 
			 * System.out.println("Service changes");
			 * 
			 * feb.training.springboot.services.singletoninprotype.OrderService proto1
			 * =(feb.training.springboot.services.singletoninprotype.OrderService)
			 * context.getBean("orderproto");
			 * feb.training.springboot.services.singletoninprotype.OrderService proto2
			 * =(feb.training.springboot.services.singletoninprotype.OrderService)
			 * context.getBean("orderproto"); System.out.println(proto1);
			 * System.out.println(proto2);
			 */
		 
	     System.out.println("Prototype Into Singleton");
		 OrderService service1=(OrderService) context.getBean("protosingle");
		 OrderService service2=(OrderService) context.getBean("protosingle");
		 System.out.println(service1);
		 System.out.println(service2);
		 
	}

}
