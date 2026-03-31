package feb.training.springboot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name= "querytab")


@NamedQuery(
		name="fetchall",
		query = "select q from QueryTab q"
		)




@NamedNativeQuery(
	    name = "QueryTab.getAllNative",
	    query = "SELECT * FROM querytab",
	    resultClass = QueryTab.class
	)



public class QueryTab {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	//@Column(name="quid")
    private Integer queryid;
	private String query;
	private String fromuser;
}
