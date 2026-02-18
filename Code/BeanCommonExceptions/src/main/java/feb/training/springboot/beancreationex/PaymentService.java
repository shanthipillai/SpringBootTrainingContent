package feb.training.springboot.beancreationex;



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
