package feb.training.springboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="empentities")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Employee {

	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="empid")
	private int id;
	@Column(name="empname")
	private String name;
	@Column(name="empdept")
	private String department;
}
