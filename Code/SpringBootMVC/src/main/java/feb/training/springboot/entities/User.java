package feb.training.springboot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "userentity")
public class User {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long userid;
	private String name;
	private String email;
	private String password;
}
