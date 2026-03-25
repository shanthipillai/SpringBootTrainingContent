package feb.training.springboot.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Roles {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer roleid;
	//@Column(unique = true)
	private String rolename;
	@ManyToMany(mappedBy = "roles")
	private List<User> users;
}
