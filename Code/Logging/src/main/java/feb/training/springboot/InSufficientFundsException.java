package feb.training.springboot;
//User Defined Exception

public class InSufficientFundsException extends RuntimeException {

	InSufficientFundsException()
	{
		System.out.println("Insufficient funds in your account!!!");
	}
}
