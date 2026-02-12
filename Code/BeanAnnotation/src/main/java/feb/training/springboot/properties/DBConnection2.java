package feb.training.springboot.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("dbconnect2")
@ConfigurationProperties(prefix = "db2")
public class DBConnection2 {
      @Value("${username}")
	  String username;
      @Value("${password}")
	  String password;
	  DBConnection2()
	  {
		  System.out.println("DB connection settings");
	  }
	  
	  public void showDBDetails()
	  {
		  System.out.println(username);
		  System.out.println(password);
	  }
}
