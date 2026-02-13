package feb.training.springboot.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
@Component
@Validated
@ConfigurationProperties(prefix="user")
public class UserDetails {

	@NotBlank
	//@Value("${userName}")
	private String userName;
	@Email
	//@Value("${email}")
	private String email;
	@Pattern(
	        regexp = "[0-9]{10}",
	        message = "Invalid mobile number"
	    )
	//@Value("${contact}")
	private String contact;
	@NotNull
	Address address;
	@Autowired
	public UserDetails(@NotNull Address address) {
		super();
		this.address = address;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "UserDetails [userName=" + userName + ", email=" + email + ", contact=" + contact + ", address="
				+ address.streename + address.getCity()+address.getPincode() +"]";
	}
	
	
	
	
	
}
