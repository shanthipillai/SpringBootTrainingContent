package feb.training.springboot.service;

import org.springframework.stereotype.Service;

import feb.training.springboot.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class EmployeeService {

	@PersistenceContext
	EntityManager entityManager;

	@Transactional

	public Employee createEmployee() {
		/*
		 * Employee emp=new Employee(224,"Arjun","tech"); entityManager.remove(emp);
		 */
		Employee emp = entityManager.find(Employee.class, 124);
		entityManager.remove(emp);
		/*
		 * Employee emp =entityManager.find(Employee.class, 114);
		 * entityManager.remove(emp);
		 */

		/*
		 * entityManager.persist(emp); entityManager.flush(); entityManager.detach(emp);
		 * // emp.setName("James"); emp=entityManager.merge(emp); emp.setName("Ryan");
		 */
		// entityManager.flush();
		/*
		 * System.out.println("Managed : " + entityManager.contains(emp));
		 * 
		 * entityManager.detach(emp);
		 * 
		 * System.out.println("Detached : " + entityManager.contains(emp));
		 * 
		 * emp.setName("Shanthi"); // emp = entityManager.merge(emp);
		 * 
		 * //entityManager.remove(emp);
		 */ return emp;
	}

}
