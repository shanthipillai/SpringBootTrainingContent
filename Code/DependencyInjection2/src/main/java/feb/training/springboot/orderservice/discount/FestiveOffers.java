package feb.training.springboot.orderservice.discount;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "discount.endabled", havingValue = "true", matchIfMissing = false

)
public class FestiveOffers implements DiscountSer {

	@Override
	public double applyDiscount(double amount) {
		System.out.println("Wohoo Festive Discount Applied");
		return amount*0.9;
	}

}
