package feb.training.springboot.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
@Configuration
public class SwaggerConfig {
	 @Bean
	    public GroupedOpenApi employeeV1Api() {
	        return GroupedOpenApi.builder()
	                .group("employees-v1")
	                .pathsToMatch("/employees/v1/**")
	                .build();
	    }

	    @Bean
	    public GroupedOpenApi employeeV2Api() {
	        return GroupedOpenApi.builder()
	                .group("employees-v2")
	                .pathsToMatch("/employees/v2/**")
	                .build();
	    }
	}

