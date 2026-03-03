package customer.service.details;

import java.time.LocalDate;

public class Customer {

	double amount;
	String name;
	ModeOfPayment payment;
	public Customer(double amount, String name, ModeOfPayment payment) {
		super();
		this.amount = amount;
		this.name = name;
		this.payment = payment;
	}
	
	public void generateReceipt()
	{
		System.out.println("Bill Generated on "+LocalDate.now());
		System.out.println("Name="+name);
		System.out.println("Amount paid="+amount);
		System.out.println("Mode of Payment "+payment.modeOfPayment());
		System.out.println("***\tThank You \t***");
	}
	
}
