package feb.training.springboot.orderServ;

import org.springframework.stereotype.Component;

import feb.training.springboot.Payment;
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
