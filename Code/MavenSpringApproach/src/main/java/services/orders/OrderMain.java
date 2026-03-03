package services.orders;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class OrderMain {
public static void main(String[] args) {
	/*
	 * //Bean Factory - Spring Boot Container - Approach 1
	 * 
	 * 
	 * //Create object for DefaultListableBeanFactory class , also test lazy
	 * initialization DefaultListableBeanFactory factory = new
	 * DefaultListableBeanFactory(); //Pass this object into XmlBeanDefinitionReader
	 * constructor XmlBeanDefinitionReader reader= new
	 * XmlBeanDefinitionReader(factory); //Provide the class path
	 * reader.loadBeanDefinitions(new ClassPathResource("application.xml"));
	 * 
	 * Orders bean=factory.getBean("orderservice", Orders.class);
	 * 
	 * bean.placeOrder();
	 */
	  
	//ApplicationContext - Approach 2  
		
		  ApplicationContext context = new
		  ClassPathXmlApplicationContext("application.xml");
		  
		  
		  
		  Orders orders =(Orders) context.getBean("orderservice"); 
		  orders.placeOrder();
		 
		 
	  
	  
}
}
