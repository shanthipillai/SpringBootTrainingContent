package feb.training.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import feb.training.springboot.entities.OrderTrans;
import feb.training.springboot.entities.PaymentTrans;
import feb.training.springboot.repo.OrderRepo;
import feb.training.springboot.repo.PaymentRepo;

@Service
public class PaymentService {

	@Autowired
	PaymentRepo payementrepo;
	
	//  @Autowired OrderRepo orderrepo;
	 
		
		  @Autowired AuditService auditservice;
		 
	//@Transactional(propagation = Propagation.MANDATORY)
	@Transactional
	public void placePaymentService()
	{
		/*
		 * Optional<OrderTrans> presents=orderrepo.findById(3);
		 * 
		 * 
		 * if(presents.isPresent()) { System.out.println("Present Yes"); } else {
		 * System.out.println("Not present"); }
		 */
		 
		System.out.println("Order Tx Active: " +
		        TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Tx Resource: " +
			    TransactionSynchronizationManager.getResourceMap());
		
		
		PaymentTrans payment=new PaymentTrans();
		payment.setPaymenttype("Credit Card");
		
		
		
		payementrepo.save(payment); //3rd record
		
		Optional<PaymentTrans> paymentpresent=payementrepo.findById(5);
		
		if(paymentpresent.isPresent())
		{
			System.out.println("Present");
		}
		else
		{
			System.out.println("Not Present");
			
		}
		
		
		//Exception Handle
		
		  try { 
			  auditservice.initiateAudit(); 
			  
		  } catch(Exception e) {
		  System.out.println("Exception occured in audit but continuing"); }
		 
		//throw new RuntimeException("Runtime error occured");
	}
}
