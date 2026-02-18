package feb.training.springboot.beancreationex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


//Bean Creation Exception
@SpringBootApplication
public class BeanCommonExceptionsApplication {

	public static void main(String[] args) {
	ApplicationContext context	=SpringApplication.run(BeanCommonExceptionsApplication.class, args);
	
	OrderService order=(OrderService) context.getBean("order");
	order.printReceipt();
	}

}
