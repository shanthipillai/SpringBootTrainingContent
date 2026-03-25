package feb.training.springboot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FixedDeposits {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fid;
	private Double amount;
	private Integer tenure;
	@ManyToOne
	@JoinColumn(name="customerid")
	private Customer customer;
	
}
