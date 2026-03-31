package feb.training.springboot.config;


import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class JacksonConfig {
	/*
	 * @Bean public ObjectMapper objectMapper() { ObjectMapper mapper = new
	 * ObjectMapper(); mapper.enable(JsonParser.Feature.STRICT_DUPLICATE_DETECTION);
	 * return mapper; }
	 */
	
	
	@Bean
	public Jackson2ObjectMapperBuilderCustomizer customizer() {
	    return builder -> builder.featuresToEnable(
	        JsonParser.Feature.STRICT_DUPLICATE_DETECTION
	    );
	}
}