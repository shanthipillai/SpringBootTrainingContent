package feb.training.springboot.company.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "company")
public class Employee {

	
	 @GeneratedValue(strategy = GenerationType.IDENTITY) // or AUTO for Oracle
    @Id
    private Integer empid;

    private String empemail;
    private String emppwd;
    private int companyexp;
    private double billing;
    private String prjctname;

    // Getters & Setters
}