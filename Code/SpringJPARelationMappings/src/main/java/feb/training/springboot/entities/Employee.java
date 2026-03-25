package feb.training.springboot.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="emp121")
public class Employee {
	/*
	 * //Oracle  Sequence Creation
	 * 
	 * @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seqgen")
	 * 
	 * @SequenceGenerator( name="emp_seqgen", sequenceName = "emp_seq",
	 * allocationSize = 1 )
	 */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long empid;
	private String empname;
	private String company;
	private LocalDate dateOfJoining;
	private Integer yearsofexperience;
	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
	private Profile profile;
}
