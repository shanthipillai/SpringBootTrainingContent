package feb.training.springboot.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@Component("dbconnect2")

@ConfigurationProperties(prefix = "db2")

public class DBConnection2 {
	// @Value("${username}")
	@NotBlank(message = "Field should not be blank")
	String username;
	// @Value("${password}")
	@NotBlank(message = "Field should not be blank")
	String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	DBConnection2() {
		System.out.println("DB connection settings");
	}

	public void showDBDetails() {
		System.out.println(username);
		System.out.println(password);
	}
}
