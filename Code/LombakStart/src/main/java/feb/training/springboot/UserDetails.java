package feb.training.springboot;


import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "assignment2.user")
@Component("user")
/*
 * @Setter
 * 
 * @Getter
 * 
 * @ToString
 */
@Data
public class UserDetails {

	@NotBlank(message = "name should not be blank")
	private String name;

	@Pattern(regexp = "^[6-9]\\d{9}$", message = "contact must be a valid 10-digit number")
	private String contact;

	@NotBlank(message = "email should not be blank")
	@Email(message = "Please provide the valid email id")
	private String email;

	@NotNull(message = "address must not be null")
	@Valid
	private Address address;

	/*
	 * public String getName() { return name; }
	 * 
	 * public void setName(String name) { this.name = name; }
	 * 
	 * public String getContact() { return contact; }
	 * 
	 * public void setContact(String contact) { this.contact = contact; }
	 * 
	 * public String getEmail() { return email; }
	 * 
	 * public void setEmail(String email) { this.email = email; }
	 * 
	 * public Address getAddress() { return address; }
	 * 
	 * public void setAddress(Address address) { this.address = address; }
	
	@Override
	public String toString() {
		return "UserDetails{" +
				"name='" + name + '\'' +
				", contact='" + contact + '\'' +
				", email='" + email + '\'' +
				", address=" + address +
				'}';
	}
	*/
}
