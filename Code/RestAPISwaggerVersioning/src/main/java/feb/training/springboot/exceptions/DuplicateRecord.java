package feb.training.springboot.exceptions;

public class DuplicateRecord extends RuntimeException {
	public DuplicateRecord(String message)
	{
		super(message);
		
	}
}
