package feb.training.springboot;

import org.springframework.stereotype.Service;

@Service
public class UPI implements Payment {
	@Override
	public void pay() {
		System.out.println("UPI payment selected");
	}

}
