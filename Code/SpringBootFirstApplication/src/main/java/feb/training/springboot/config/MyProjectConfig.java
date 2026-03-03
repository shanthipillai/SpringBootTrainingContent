package feb.training.springboot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan(
basePackages = { "outside.training.feb","feb.training.springboot" }, 
useDefaultFilters = false, 
includeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class

		) }

)

public class MyProjectConfig {

}
