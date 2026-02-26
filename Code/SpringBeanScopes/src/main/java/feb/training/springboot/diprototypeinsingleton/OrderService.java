package feb.training.springboot.diprototypeinsingleton;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("protoinsigl")
@Scope("singleton")
public class OrderService {
	ObjectProvider<PaymentService> objpaymentservice;

	public OrderService(ObjectProvider<PaymentService> objpaymentservice) {
		super();
		this.objpaymentservice = objpaymentservice;
		System.out.println("OrderService Object Created"+this.hashCode());
		System.out.println("Object Provider Object Created="+objpaymentservice);
		
	}
	
	public void getDetails()
	{
		objpaymentservice.getObject().pay();
	}
	
}
