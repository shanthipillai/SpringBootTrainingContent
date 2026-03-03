package feb.training.springboot.services.singletoninprotypesol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


//Try Lookup

@SpringBootApplication
public class ScopesSingletonPrototypeApplication {

	public static void main(String[] args) {
		
		  ApplicationContext context=SpringApplication.run(ScopesSingletonPrototypeApplication.class,args); 
			
		 
	     System.out.println("Prototype Into Singleton");
		 OrderService service1=(OrderService) context.getBean("orderproto");
		 OrderService service2=(OrderService) context.getBean("orderproto");
		 System.out.println(service1);
		 System.out.println(service2);
		 
	}

}
