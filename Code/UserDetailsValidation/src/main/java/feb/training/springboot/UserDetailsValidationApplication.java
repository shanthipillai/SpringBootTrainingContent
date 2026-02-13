package feb.training.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import feb.training.springboot.components.UserDetails;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
@PropertySource("classpath:user.properties")
public class UserDetailsValidationApplication {

	 private final UserDetails userDetails;

	    public UserDetailsValidationApplication(UserDetails userDetails) {
	        this.userDetails = userDetails;
	    }
	@PostConstruct
	public void check() {
	    System.out.println(userDetails);
	}

	public static void main(String[] args) {
		SpringApplication.run(UserDetailsValidationApplication.class, args);
	}

}
