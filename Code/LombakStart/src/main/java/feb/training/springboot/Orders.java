package feb.training.springboot;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component("orderz")
@RequiredArgsConstructor
public class Orders {

	
	//public PaymentMode pay;
	public final PaymentMode pay;
	
	public void bill()
	{
		pay.paid();
	}
}
