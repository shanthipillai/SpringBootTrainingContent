package feb.training.springboot.nouniqbeanex;



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
