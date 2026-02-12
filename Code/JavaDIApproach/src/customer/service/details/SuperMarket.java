package customer.service.details;

public class SuperMarket {

	public static void main(String[] args) {
		ModeOfPayment payment=new Card();
		Customer customer1=new Customer(15000.00,"Madhuri",payment);
		customer1.generateReceipt();
	}

}
