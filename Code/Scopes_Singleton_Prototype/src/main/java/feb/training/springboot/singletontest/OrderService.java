package feb.training.springboot.singletontest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("singletontest")
@Scope("singleton")
public class OrderService {
	public OrderService()
	{
		//OrderService obj=new OrderService(); //this
		//current class object
		//System.out.println(this);
		System.out.println(this.hashCode());
	}
}
