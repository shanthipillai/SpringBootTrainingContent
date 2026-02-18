package feb.training.springboot.nosuchbeanex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


//No Such Bean Exception _ UnSatisfied Dependency Exception (On no debug)
@SpringBootApplication
public class BeanCommonExceptionsApplication {

	public static void main(String[] args) {
	ApplicationContext context	=SpringApplication.run(BeanCommonExceptionsApplication.class, args);
	
	OrderService order=(OrderService) context.getBean("order");
	order.printReceipt();
	}

}
