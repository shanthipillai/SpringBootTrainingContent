package feb.training.springboot.lookup;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Audit {
	public Audit()
	{
		System.out.println(this.hashCode());
	}

	public void results() {
		System.out.println("Done");
		
	}
}
