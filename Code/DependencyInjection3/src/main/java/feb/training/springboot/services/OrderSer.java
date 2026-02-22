package feb.training.springboot.services;


import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;


import lombok.RequiredArgsConstructor;

@Component("order")
@RequiredArgsConstructor
public class OrderSer {
	public final PaymentMode pay;
	//NotificationService notificationservice;
	//public ObjectProvider<NotificationService> notification;

	@Lookup
	
	public NotificationService getService()
	{
		return null;
	}
	public void placeOrder(double amount) {
		pay.pay(5000);
		getService().sendNotification();
		
		

	}
	
}
