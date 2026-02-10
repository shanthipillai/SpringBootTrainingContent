package feb.training.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import feb.training.springboot.config.MyProjectConfig;

@SpringBootApplication
@Import(MyProjectConfig.class)
@ComponentScan(useDefaultFilters = false)
/*
 * (
 * 
 * scanBasePackages = { "feb.training.springboot", "outside.training.feb"
 * 
 * } )
 */
public class SpringBootApplicationAnnotatenewApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplicationAnnotatenewApplication.class, args);
	}

}
