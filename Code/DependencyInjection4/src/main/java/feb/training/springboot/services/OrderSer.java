package feb.training.springboot.services;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component("order")
@AllArgsConstructor
public class OrderSer {
	
	/*
	 * OrderSer(PaymentMode pay, ObjectProvider<NotificationService> notification) {
	 * 
	 * }
	 */
	public PaymentMode pay;
	//@Lazy
	//public NotificationService notification;
	
	public ObjectProvider<NotificationService> notification;

	public void placeOrder(double amount) {
		pay.pay(5000);
		
		//Java 8 approach
		
		notification.forEach(notify->notify.sendNotification());
		

	}
}
