package feb.training.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import feb.training.springboot.entities.Audit;
import feb.training.springboot.repo.AuditRepo;

@Service
public class AuditService {

	@Autowired
	
	AuditRepo auditrepo;
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void initiateAudit()
	{
		System.out.println("Order Tx Active: " +
		        TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Tx Resource: " +
			    TransactionSynchronizationManager.getResourceMap());
		
		
		Audit audit=new Audit();
		audit.setAuditupdate("All Set No Issues");
		auditrepo.save(audit);
		
		
		
		throw new RuntimeException("Exception occured");
	}
}
