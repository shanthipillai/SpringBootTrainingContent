package feb.training.springboot.disingletoninproto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("orders")
@Scope("prototype")
public class Orders {

	Cutomer customer;

	@Autowired
	public Orders(Cutomer customer) {
		super();
		this.customer = customer;
		System.out.println("Orders Hash Code"+this.hashCode());
	}
	
}
