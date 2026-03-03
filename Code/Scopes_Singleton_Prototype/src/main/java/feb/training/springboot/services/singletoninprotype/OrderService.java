package feb.training.springboot.services.singletoninprotype;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("orderproto")

@Scope("prototype")
public class OrderService {

	
	AuditService audit;

	public OrderService(AuditService audit) {
		super();
		this.audit = audit;
		System.out.println("Prototype");
		System.out.println(this.hashCode()+"Order Service created with audit object "+audit);
	}
	
	
}
