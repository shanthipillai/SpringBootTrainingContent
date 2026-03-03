package feb.training.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import feb.training.springboot.orderServ.OrderService;

@SpringBootApplication
public class ValidationAssignmentApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(ValidationAssignmentApplication.class, args);
	    UserDetails userdetails=(UserDetails) context.getBean("user");
	    System.out.println(userdetails);
		/*
		 * OrderService service=(OrderService) context.getBean("order");
		 * service.getOrderDetails();
		 * 
		 * Laptop laptop= Laptop.builder().color("while").size(5).brand("Dell").build();
		 * System.out.println(laptop);
		 * 
		 * Orders orderz=(Orders) context.getBean("orderz"); orderz.bill();
		 */
	}

}
