package feb.training.springboot.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("customer")
public class Customer {
	
	String customerName;
    double amount;
    ModeOfPayment modeOfPayment;
    EmailService emailservice;
    Customer() {
    	//modeOfPayment=null; 
    	System.out.println("Constructor Injection");
    	System.out.println(modeOfPayment);
    	
    } //Constructor Injection
    
	/*
	 * Customer() { modeOfPayment=null; } //Constructor Injection
	 * 
	 * @Autowired Customer(ModeOfPayment modeOfPayment) { super();
	 * this.modeOfPayment = modeOfPayment; }
	 */
    
    
    
    
	public void generateBill(String customerName, double amount )
	{
		this.customerName=customerName;
		this.amount=amount;
		System.out.println("Name="+customerName);
		System.out.println("Amount Paid="+amount);
		modeOfPayment.paymentType();
		System.out.println("*** \t Thank You \t ***");
		
	}

	public ModeOfPayment getModeOfPayment() {
		return modeOfPayment;
	}

	@Autowired
	public void setModeOfPayment(ModeOfPayment modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	
	
	

}
