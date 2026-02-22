package feb.training.springboot;

import org.springframework.boot.ApplicationArguments;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)

public class ApplicationRunner implements org.springframework.boot.ApplicationRunner {

	private final Customer customer;
	
	public ApplicationRunner(Customer customer) {
		super();
		this.customer = customer;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Application Runner ready");
		customer.showDetails();

	}

}
