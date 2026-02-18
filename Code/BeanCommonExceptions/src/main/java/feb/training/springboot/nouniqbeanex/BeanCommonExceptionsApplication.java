package feb.training.springboot.nouniqbeanex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


//No Unique Bean Definition Exception  _ UnSatisfied Bean Definition (on no debug)
@SpringBootApplication
public class BeanCommonExceptionsApplication {

	public static void main(String[] args) {
	ApplicationContext context	=SpringApplication.run(BeanCommonExceptionsApplication.class, args);
	
	OrderService order=(OrderService) context.getBean("order");
	order.printReceipt();
	}

}
