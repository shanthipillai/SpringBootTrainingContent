package feb.training.springboot.services.prototypeinsingleton;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import feb.training.springboot.services.PaymentService;


@Component("protosingle")
public class OrderService {

	PayService service;
	public OrderService(PaymentService service)
	{
		System.out.println(this.hashCode()+"="+service);
	}
}
