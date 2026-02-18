package feb.training.springboot.beancommonex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


//Conflict Bean Definition Exception _ BeanCommonException (On no debug)
@SpringBootApplication
public class BeanCommonExceptionsApplication {

	public static void main(String[] args) {
	ApplicationContext context	=SpringApplication.run(BeanCommonExceptionsApplication.class, args);
	
	OrderService order=(OrderService) context.getBean("order");
	order.printReceipt();
	}

}
