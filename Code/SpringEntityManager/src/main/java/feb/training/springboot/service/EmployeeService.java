package feb.training.springboot.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.reactive.TransactionSynchronization;
import org.springframework.transaction.reactive.TransactionSynchronizationManager;

import feb.training.springboot.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;
import jakarta.transaction.Transactional;

@Service
public class EmployeeService {

	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	EntityManager entitymanager;

	@Transactional
	public Employee createEmployee() {
 /*
		entitymanager.persist(emp);
		System.out.println(entitymanager.contains(emp));
		entitymanager.detach(emp);
		Employee newemp=entitymanager.merge(emp);
		newemp.setName("Changed");
		entitymanager.remove(newemp);
		printStats();
		return emp;
		*/
		Employee emp=new Employee(1,"Shanthi","DEV");
		entitymanager.persist(emp);
		//entitymanager.flush();
		emp.setDept("Manager");
		entitymanager.flush();
		entitymanager.clear(); 
		Employee e = entitymanager.find(Employee.class, 1L);
		
		System.out.println(e.getDept()+""+e.getId());
		
		  if(true) { throw new RuntimeException("Rollback"); }
		 
		return emp;
	}

	@Transactional
	public Employee test() {

		Employee emp = new Employee();
		emp.setName("John");
		emp.setDept("DEV");

		entitymanager.persist(emp);
		emp.setDept("QA");
		System.out.println("PRinting");
		 List<Employee> list = entitymanager
		            .createQuery("select e from Employee e", Employee.class)
		            .getResultList();
		org.springframework.transaction.support.TransactionSynchronizationManager.registerSynchronization(
				new org.springframework.transaction.support.TransactionSynchronization() {
					 @Override
			            public void afterCommit() {
			                printStats();
			            }
				}
);

		return emp;

	}

	public void printStats() {

		SessionFactory sessionFactory = entitymanager.getEntityManagerFactory().unwrap(SessionFactory.class);

		Statistics stats = sessionFactory.getStatistics();

		System.out.println("Entity Inserts: " + stats.getEntityInsertCount());
		System.out.println("Entity Updates: " + stats.getEntityUpdateCount());
		System.out.println("Queries executed: " + stats.getQueryExecutionCount());
	}

	
	@Transactional
	public Employee postEmployee() {
		Employee emp=new Employee(1,"Shanthi","DEV");
		entitymanager.persist(emp);
		return emp;
	}

	public List<Employee> getAllEmps() {
		 String jpql = "SELECT e FROM Employee e";

	        List<Employee> employees =
	        		entitymanager.createQuery(jpql, Employee.class)
	                             .getResultList();

		return employees;
	}

	public Employee findById(int id) {
		return entitymanager.find(Employee.class, id);
		
	}

	@Transactional
	public Employee transtransactionmangt(Employee emp) {
		entitymanager.persist(emp);
		Employee empret=findById(emp.getId());
		empret.setName("Hello");
		transtransactionmangt2(empret);
		
		return empret;
	}
	
	@Transactional
	public Employee transtransactionmangt2(Employee emp) {
		entitymanager.persist(emp);
		Employee empret=findById(emp.getId());
		empret.setName("Hello1");
		
		return empret;
	}

	@Transactional
	public String batchInserts() {
		 for(int i = 1; i <= 100; i++) {

	            Employee emp = new Employee();
	            emp.setName("Employee " + i);
	            emp.setDept("IT");

	            entitymanager.persist(emp);

	            if(i % 50 == 0) {

	            	entitymanager.flush();
	            	entitymanager.clear();

	            }
	
	}
		return "Success";
	}

}
