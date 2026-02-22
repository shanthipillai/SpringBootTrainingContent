package feb.training.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootLifeCycleApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringBootLifeCycleApplication.class, args);
		//Customer customer=(Customer) context.getBean("customer");
		//customer.showDetails();
		System.out.println("Done from App side");
	}

}
