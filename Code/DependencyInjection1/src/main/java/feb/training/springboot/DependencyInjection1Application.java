package feb.training.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import feb.training.springboot.components.Customer;

@SpringBootApplication
public class DependencyInjection1Application {

	public static void main(String[] args) {
	ApplicationContext context	=SpringApplication.run(DependencyInjection1Application.class, args);
	Customer customerobj=(Customer) context.getBean("customer");
	customerobj.generateBill("Madhuri", 15000);
	}

}
