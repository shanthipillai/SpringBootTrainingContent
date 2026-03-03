package feb.training.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LoggingApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(LoggingApplication.class, args);
		OrderService service=(OrderService) context.getBean("orderservice");
		service.getDetails(-1);
	}

}
