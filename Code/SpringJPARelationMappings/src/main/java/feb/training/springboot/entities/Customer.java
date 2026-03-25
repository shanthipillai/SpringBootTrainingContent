package feb.training.springboot.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="customer1tom")
public class Customer {


	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long customerid;
	private String customername;
	@OneToMany(mappedBy ="customer", cascade = CascadeType.ALL)
	private List<FixedDeposits> fixeddeposits;
}
