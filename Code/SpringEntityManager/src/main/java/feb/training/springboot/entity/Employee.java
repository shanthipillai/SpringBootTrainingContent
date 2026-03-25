package feb.training.springboot.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "employeeentity")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employee

{
	  @SequenceGenerator( name = "emp_seq", sequenceName = "employee_sequence",
	  initialValue = 100, allocationSize = 50 )
	 
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq")
    @Id
	@Column(name = "empid")
	private int id;
    @Column(name="empname")
    private String name;
    @Column(name="empdept")
    private String dept;
       

}
