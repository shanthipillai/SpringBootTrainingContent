package feb.training.springboot;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Laptop {

	private String brand;
	private int ramSize;
	private String processor;
	private int size;
	private String color;
	
	
}
