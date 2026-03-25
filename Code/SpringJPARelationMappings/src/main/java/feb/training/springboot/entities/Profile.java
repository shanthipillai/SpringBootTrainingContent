package feb.training.springboot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer profiid;
	private String aadharcard;
	private String pancard;
	private String uan;
	private String mobile;
	private String address;
	@OneToOne
	//FK
	@JoinColumn(name="empid")
	private Employee employee;
}
