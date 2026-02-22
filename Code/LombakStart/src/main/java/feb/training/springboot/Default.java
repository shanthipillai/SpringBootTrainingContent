package feb.training.springboot;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Default implements Payment {

	@Override
	public void pay() {
		System.out.println("Default payment selected");
	}
	

}
