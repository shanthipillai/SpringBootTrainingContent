package feb.training.springboot.prototype;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("prototypebean")
@Scope("prototype")
public class OrderService {
	public OrderService()
	{
		System.out.println(this.hashCode());
	}
}
