package feb.training.springboot.services;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component("order")
@AllArgsConstructor
public class OrderSer {
	public PaymentMode pay;
	public ObjectProvider<NotificationService> notification;

	public void placeOrder(double amount) {
		pay.pay(5000);
		
		notification.forEach(notify->notify.sendNotification());

	}
}
