package feb.training.springboot;

import jakarta.validation.constraints.NotBlank;

public class Address {

	@NotBlank(message = "street must not be blank")
	private String street;

	@NotBlank(message = "city must not be blank")
	private String city;

	@NotBlank(message = "zipCode must not be blank")
	private String zipCode;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Address{" +
				"street='" + street + '\'' +
				", city='" + city + '\'' +
				", zipCode='" + zipCode + '\'' +
				'}';
	}
}
