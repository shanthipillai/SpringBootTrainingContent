package feb.training.springboot.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

import feb.training.springboot.component.DefaultPayment;
import feb.training.springboot.component.EmailService;
import feb.training.springboot.component.ModeOfPayment;
import feb.training.springboot.component.Order;
import feb.training.springboot.component.Payment;
import feb.training.springboot.component.ServerMaintenanceMode;
import feb.training.springboot.config.condition.ServerMaintenanceCheck;


@Configuration
//"file:D:/path/to/your/config.properties"
@PropertySource("classpath:dbprops.properties")

public class MainConfig {
	
	  @Bean
	  public Order getOrder() { return new Order(); }
	  
	  //Other Classes 
	  
	  @Bean
	  public RestTemplate getTemplate()
	  {
		  return new RestTemplate();
	  }
	  
	
	  
	  
	  @Bean
	  @Conditional(ServerMaintenanceCheck.class)
	  public ServerMaintenanceMode enableServerMaintenanceMode()
	  {
		  return new ServerMaintenanceMode();
	  }
	  
	  @Bean
	  @ConditionalOnProperty(name = "smtp.server" , havingValue = "enable")
	  public EmailService emailService()
	  {
		  return new EmailService();
	  }
	  
	  @Bean
	  @ConditionalOnClass(RestTemplate.class)
	  public RestTemplate createRestTemplate()
	  {
		  return new RestTemplate();
	  }
	  
	  @Bean
	  @ConditionalOnBean(Order.class)
	  public Payment initiatePayment()
	  {
		  return new Payment();
	  }
	  
	  @Bean
	  @ConditionalOnMissingBean
	  public ModeOfPayment defaultPayment()
	  {
		return new DefaultPayment();
		  
	  }
	 
}
