package feb.training.springboot.services.singletoninprotypesol;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("orderproto")

@Scope("prototype")
public class OrderService {

	ObjectProvider<AuditService> audit;
	//AuditService audit;

	public OrderService(ObjectProvider<AuditService> audit) {
		super();
		this.audit = audit;
		 System.out.println("Prototype");
		 System.out.println(this.hashCode()+"Order Service created with audit object "
		 +audit); }
	}

	/*
	 * public OrderService(AuditService audit) { super(); this.audit = audit;
	 * System.out.println("Prototype");
	 * System.out.println(this.hashCode()+"Order Service created with audit object "
	 * +audit); }
	 */
	
	

