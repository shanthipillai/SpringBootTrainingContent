package feb.training.springboot.services;

import org.springframework.stereotype.Component;

@Component

public class SmsNotification implements NotificationService {

	@Override
	public void sendNotification() {
	System.out.println("Order has been placed::SMS");

	}

}
