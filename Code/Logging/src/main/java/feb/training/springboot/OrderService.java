package feb.training.springboot;

import org.springframework.stereotype.Component;

import feb.training.springboot.payment.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component("orderservice")
@Slf4j // logger object create
@AllArgsConstructor
public class OrderService {

	PaymentMode paymentype;
	
	public void getDetails(double amount)
	{
		log.debug("Fetching Payment Details");
		log.info("Amount ="+amount);
		try
		{
		if(amount>0)
		{
		paymentype.pay(5000);
		}
		else
		{
			
			log.warn("User entered insufficient funds");
			throw new InSufficientFundsException();
		}
		
		}
		catch(InSufficientFundsException ex)
		{
			log.error("Insufficient Funds",ex);
		}
	}

}
