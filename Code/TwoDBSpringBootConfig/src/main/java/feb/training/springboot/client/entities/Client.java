package feb.training.springboot.client.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "client")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq_gen")
	@SequenceGenerator(
			name = "client_seq_gen",
			sequenceName = "client_seq",
			allocationSize = 1
			
			)
    private Integer clientid;

    private Integer empid;   // reference to company DB

    private String clientemail;
    private String clientpwd;
    private int clientexp;

    // Getters & Setters
}