package feb.training.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="usertab")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class User {

	@Id
	@Column(name="username")
	private String userName;
	@Column(name="pasword")
	 @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	@Column(name="role")
	private String role;
}
