package feb.training.springboot.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {
	private String area;
	private String doorno;
	private String city;
	private String pincode;

}
