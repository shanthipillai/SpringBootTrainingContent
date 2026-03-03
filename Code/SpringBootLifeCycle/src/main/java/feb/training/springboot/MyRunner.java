package feb.training.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class MyRunner implements CommandLineRunner {

	private final Customer customer;
	
	public MyRunner(Customer customer) {
		super();
		this.customer = customer;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Command Line Runner ready");
		customer.showDetails();
	}

}
