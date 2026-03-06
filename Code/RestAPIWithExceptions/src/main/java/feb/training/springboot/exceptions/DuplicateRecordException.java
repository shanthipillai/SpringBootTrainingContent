package feb.training.springboot.exceptions;

public class DuplicateRecordException extends RuntimeException {

	
	public DuplicateRecordException(String message)
	{
		super(message);
	}
}
