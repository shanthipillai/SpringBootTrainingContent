package feb.training.springboot.customendpoints;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="sendmessage")
public class CustomWriteEndpoint {
    @WriteOperation
	public String writeMeassage(String message)
	{
		return "Message Updated"+message;
	}
}
