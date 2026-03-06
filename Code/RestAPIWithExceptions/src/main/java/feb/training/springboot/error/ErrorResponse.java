package feb.training.springboot.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ErrorResponse {

	private int httpstatus;
	private String message;
	private long timestamp;
	
}
