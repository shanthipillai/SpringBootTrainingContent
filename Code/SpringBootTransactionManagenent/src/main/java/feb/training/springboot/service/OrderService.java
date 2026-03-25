package feb.training.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import feb.training.springboot.entities.OrderTrans;
import feb.training.springboot.repo.OrderRepo;

@Service
public class OrderService {

	 @Autowired
	OrderRepo orderrepo;
	 
	 
	/*
	 * @Autowired PaymentService paymentservice;
	 */
	 
		@Transactional
	(propagation = Propagation.REQUIRED)
		public void placeOrderService() {
		
			System.out.println("Order Tx Active: " +
			        TransactionSynchronizationManager.isActualTransactionActive());
			
			
			System.out.println("Tx Resource: " +
				    TransactionSynchronizationManager.getResourceMap());
			
			
			OrderTrans order=new OrderTrans();
			order.setNoofitems(17);
			
			
			orderrepo.save(order);
			
			//paymentservice.placePaymentService();
		}
}
