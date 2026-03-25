package feb.training.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
public class AddToCart {
    @Autowired
    
	OrderService orderservice;
    
    
	public void addToCart()
	{
		System.out.println("Order Tx Active: " +
		        TransactionSynchronizationManager.isActualTransactionActive());
		
		
		orderservice.placeOrderService();
	}
}
