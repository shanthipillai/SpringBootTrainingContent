package feb.training.springboot.prototype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;






@SpringBootApplication
public class SpringBeanScopesApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBeanScopesApplication.class, args);

		// Prototype Testing
		OrderService obj1 = (OrderService) context.getBean("prototypebean");

		OrderService obj2 = (OrderService) context.getBean("prototypebean");

		System.out.println(obj1 == obj2);

	}

}
