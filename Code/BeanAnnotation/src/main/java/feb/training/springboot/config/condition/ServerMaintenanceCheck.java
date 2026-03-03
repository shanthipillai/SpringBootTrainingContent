package feb.training.springboot.config.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;


//Condition is an interface in Spring Boot
public class ServerMaintenanceCheck implements Condition
{

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		String value=context.getEnvironment().getProperty("app.maintenance");
		return "true".equalsIgnoreCase(value);
	}

}
