package feb.training.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ValidationAssignmentApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(ValidationAssignmentApplication.class, args);
	    UserDetails userdetails=(UserDetails) context.getBean("user");
	    System.out.println(userdetails);
	
	
	}

}
