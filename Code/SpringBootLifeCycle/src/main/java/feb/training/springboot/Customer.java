package feb.training.springboot;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Data;
import lombok.Setter;
import lombok.AccessLevel;
@Component("customer")
//@ConfigurationProperties(prefix="customer")
@Data
public class Customer implements InitializingBean, DisposableBean, BeanNameAware
{
    @Autowired
	ApplicationContext context;
	
	@Value("${customer.customerId}")
	private int customerId;
	@Value("${customer.customerName}")
	private String customerName;
	 @Setter(AccessLevel.NONE)
	Cards cards;
	
	public Customer(@Lazy Cards cards) {
		super();
		this.cards = cards;
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("Bean name"+name);
	}
	
	@PostConstruct
	public void postConstruct()
	{
		System.out.println("After construct");
		System.out.println(cards.typeOfCard);
		System.out.println("object created");
		System.out.println(context.containsBeanDefinition("cards"));
		System.out.println(context.containsBean("cards"));
		System.out.println(System.identityHashCode(cards));
		
	}
	
	@PreDestroy
	public void preDestroy()
	{
		System.out.println("Pre destroyed");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Bean to garbage");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet()");
		System.out.println(customerId);
		System.out.println(customerName);
		
	}
	
	public void showDetails()
	{
		System.out.println(+customerId+""+customerName+""+cards.getTypeOfCard());
	}
	
	
	
	
}
