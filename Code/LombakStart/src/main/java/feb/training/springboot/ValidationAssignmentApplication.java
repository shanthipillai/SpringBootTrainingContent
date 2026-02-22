package feb.training.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ValidationAssignmentApplication {

	public static void main(String[] args) {
		//Validation Testing by enabling lombok
		ApplicationContext context=SpringApplication.run(ValidationAssignmentApplication.class, args);
	    UserDetails userdetails=(UserDetails) context.getBean("user");
	    System.out.println(userdetails);
	    //Lombok Annotations
	    OrderService service=(OrderService) context.getBean("order");
	    service.getOrderDetails();
	
	    //Builder Pattern - Lombok
	   Laptop laptop= Laptop.builder().color("while").size(5).brand("Dell").build();
	   System.out.println(laptop);
	   //RequiredArgs - Lombok
	   Orders orderz=(Orders) context.getBean("orderz");
	   orderz.bill();
	}

}
