package feb.training.springboot.component;

public class DefaultPayment implements ModeOfPayment {
	public DefaultPayment()
	{
		System.out.println("Default payment mode enabled");
	}
	@Override
	public void modeOfPayment() {
		System.out.println("Default Payment");
	}

}
