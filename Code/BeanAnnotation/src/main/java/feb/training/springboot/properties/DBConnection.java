package feb.training.springboot.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("dbconnect")
public class DBConnection {
      @Value("${username}")
	  String username;
      @Value("${password}")
	  String password;
	  DBConnection()
	  {
		  System.out.println("DB connection settings");
	  }
	  
	  public void showDBDetails()
	  {
		  System.out.println(username);
		  System.out.println(password);
	  }
}
