package outside.training.feb;

import org.springframework.stereotype.Component;

@Component
public class PaymentComponent {
	PaymentComponent()
	{
		System.out.println("Payment component bean is created by container");
	}

}
