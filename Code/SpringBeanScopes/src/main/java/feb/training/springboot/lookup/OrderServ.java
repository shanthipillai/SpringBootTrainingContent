package feb.training.springboot.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component("orderserv")
public class OrderServ {

	Payment payment;
	Audit audit;
	OrderServ()
	{
		System.out.println("Order Service Object Created"+this.hashCode());
	}
	@Autowired
	public OrderServ(Payment payment)
	{
		this.payment=payment;
		System.out.println(audit);
	}
	@Lookup
	public Audit getAudit() {
		return null;
		
	}
	
	public void getDetails()
	{
		payment.pay();
		getAudit().results();
	}
	
}
