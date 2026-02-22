package feb.training.springboot.services;

import org.springframework.stereotype.Component;

@Component
public class EmailService implements NotificationService {

	@Override
	public void sendNotification() {
		System.out.println("Email : Order has been placed");

	}

}
