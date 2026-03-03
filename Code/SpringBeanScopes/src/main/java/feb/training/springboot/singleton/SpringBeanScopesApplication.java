package feb.training.springboot.singleton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;





@SpringBootApplication
public class SpringBeanScopesApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBeanScopesApplication.class, args);
		
		  OrderService obj1=(OrderService) context.getBean("orderservice");
		  OrderService obj2=(OrderService) context.getBean("orderservice");
		  OrderService obj3=(OrderService) context.getBean("orderservice");
		  
		  System.out.println(obj1==obj2); 
		  System.out.println(obj1==obj3);
		  System.out.println(obj2==obj3);
		  
			/*
			 * //Java Ref
			 * 
			 * OrderService ob1=new OrderService(); OrderService ob2=obj1; OrderService
			 * ob3=obj1;
			 */
		 
	}

}
