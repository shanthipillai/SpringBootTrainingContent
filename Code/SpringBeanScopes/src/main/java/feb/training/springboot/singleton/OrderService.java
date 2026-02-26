package feb.training.springboot.singleton;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("orderservice")
@Scope("singleton")
public class OrderService {
	public OrderService()
	{
		System.out.println(this.hashCode());
	}
}
