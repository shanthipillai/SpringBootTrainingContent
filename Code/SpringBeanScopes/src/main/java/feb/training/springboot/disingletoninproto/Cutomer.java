package feb.training.springboot.disingletoninproto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Cutomer {
	public Cutomer() {
     System.out.println("Customer hashcode"+this.hashCode());
	}
}
