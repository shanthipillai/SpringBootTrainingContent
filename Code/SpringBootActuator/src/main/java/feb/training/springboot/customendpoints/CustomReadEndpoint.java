package feb.training.springboot.customendpoints;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;
@Component
@Endpoint(id="appstatus")
public class CustomReadEndpoint {

	@ReadOperation
	public String allApplicationStatus()
	{
		return "All Apps are up";
	}
}
