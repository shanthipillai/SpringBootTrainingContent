package feb.training.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import feb.training.springboot.properties.DBConnection;
import feb.training.springboot.properties.DBConnection2;

@SpringBootApplication
public class BeanAnnotationApplication {

	public static void main(String[] args) {
		ApplicationContext context=
				SpringApplication.run(BeanAnnotationApplication.class, args);
		DBConnection connection=(DBConnection) context.getBean("dbconnect");
		connection.showDBDetails();
		
		DBConnection2 connection2=(DBConnection2) context.getBean("dbconnect2");
		connection2.showDBDetails();
		
		
		/*
		 * String[] names=context.getBeanDefinitionNames();
		 * System.out.println("Printing Beans"); for(String name:names) {
		 * System.out.println(name); }
		 * 
		 * 
		 * 
		 * 
		 * System.out.println("Done");
		 */
	}

}
