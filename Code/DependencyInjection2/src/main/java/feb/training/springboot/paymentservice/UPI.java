package feb.training.springboot.paymentservice;

import org.springframework.stereotype.Service;

@Service("upi")
public class UPI implements PaymentMode {

	public void pay(double amount) {
		System.out.println("Your order has been placed using UPI \nAmount= "+amount);
		
	

}
}