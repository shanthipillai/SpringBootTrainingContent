package feb.training.springboot;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Data;


//@ConfigurationProperties(prefix="customer")
@Component
@Data
public class Cards implements InitializingBean, DisposableBean , BeanNameAware {

	@Value("${customer.customerId}")
	String customerName;
	@Value("${customer.typeOfCard}")
	String typeOfCard;
	@Value("${customer.digit}")
	String digit;
	Cards()
	{
		System.out.println("Cards called"+this);
	}
	
	@Override
	public void setBeanName(String name) {
		System.out.println("Bean name"+name);
	}
	
	@PostConstruct
	public void postConstruct()
	{
		System.out.println("Payment Service After construct");
	}
	@PreDestroy
	public void preDestroy()
	{
		System.out.println("Payment Service Pre destroyed");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Payment Service Bean to garbage");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet()");
		System.out.println(typeOfCard);
		System.out.println(digit);
		
	}
	
	
}
