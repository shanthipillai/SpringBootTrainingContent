package order.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderMain {

	public static void main(String[] args) {
		   ApplicationContext context	=new AnnotationConfigApplicationContext(Orders.class);
		   Orders bean=(Orders) context.getBean("orders");
		   bean.placeOrder();

	}

}
