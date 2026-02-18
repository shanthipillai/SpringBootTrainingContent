package feb.training.springboot.ube;



/*
 *                 PaymentService
                      │
        ┌─────────────┼─────────────┐
        │             │             │
   CardPayment     UpiPayment   DefaultPayment
   Service          Service          Service

 */
public interface PaymentService {

	public void pay();
}
