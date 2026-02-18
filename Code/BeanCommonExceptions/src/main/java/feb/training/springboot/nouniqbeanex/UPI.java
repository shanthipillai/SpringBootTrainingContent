package feb.training.springboot.nouniqbeanex;


import org.springframework.stereotype.Service;

@Service("upi")
public class UPI implements PaymentService {

	@Override
	public void pay() {
		System.out.println("Paid through UPI");

	}

}
