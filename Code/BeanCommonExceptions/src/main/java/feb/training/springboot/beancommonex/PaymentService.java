package feb.training.springboot.beancommonex;



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
