package feb.training.springboot.nosuchbeanex;



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
