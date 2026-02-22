package feb.training.springboot;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
//@NoArgsConstructor
//@AllArgsConstructor
@RequiredArgsConstructor
@Component("order")
public class OrderService {

	final Payment payment;
	
	public void getOrderDetails()
	{
		payment.pay();
	}
}
