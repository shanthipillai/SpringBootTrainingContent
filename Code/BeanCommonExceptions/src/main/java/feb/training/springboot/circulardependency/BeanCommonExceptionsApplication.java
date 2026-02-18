package feb.training.springboot.circulardependency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


//Circular Dependency
@SpringBootApplication
public class BeanCommonExceptionsApplication {

	public static void main(String[] args) {
	ApplicationContext context	=SpringApplication.run(BeanCommonExceptionsApplication.class, args);
	
	Student student=(Student) context.getBean("student");
	//order.printReceipt();
	}

}
