package feb.training.springboot.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import feb.training.springboot.orderservice.discount.DiscountSer;
import feb.training.springboot.paymentservice.PaymentMode;

@Service("order")
public class OrderService {

	PaymentMode paymentMode;
	DiscountSer discountser;
	
	public OrderService(@Qualifier("cards")   PaymentMode paymentMode) {
		super();
		//System.out.println("Order placed");
		this.paymentMode = paymentMode;
	}
	
	
	public DiscountSer getDiscountser() {
		return discountser;
	}


	@Autowired(required = false)
	public void setDiscountser(DiscountSer discountser) {
		this.discountser = discountser;
	}


	public void placeOrder(double amount)
	{
		if(discountser!=null)
		{
			amount=discountser.applyDiscount(amount);
		}
		
		paymentMode.pay(amount);
		
	}
}
