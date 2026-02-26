package feb.training.springboot;

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
		/*
		 * OrderService obj1=(OrderService) context.getBean("orderservice");
		 * OrderService obj2=(OrderService) context.getBean("orderservice");
		 * OrderService obj3=(OrderService) context.getBean("orderservice");
		 * 
		 * System.out.println(obj1==obj2); System.out.println(obj1==obj3);
		 * System.out.println(obj2==obj3);
		 * 
		 * 
		 * OrderService ob1=new OrderService(); OrderService ob2=obj1; OrderService
		 * ob3=obj1;
		 */

		/*
		 * //Prototype Testing OrderService obj1=(OrderService)
		 * context.getBean("prototypebean");
		 * 
		 * OrderService obj2=(OrderService) context.getBean("prototypebean");
		 * 
		 * System.out.println(obj1==obj2);
		 */

		// Tested Prototype in Singleton Bean
		OrderService obj1 = (OrderService) context.getBean("protoinsigl");
		obj1.getDetails();
		OrderService obj2 = (OrderService) context.getBean("protoinsigl");
		obj2.getDetails();

		/*
		 * Orders order1=(Orders) context.getBean("orders"); Orders order2=(Orders)
		 * context.getBean("orders");
		 */

	}

}
