package feb.training.springboot.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
@Component
@ConfigurationProperties(prefix="addr")
public class Address {
    public String getStreename() {
		return streename;
	}
	public void setStreename(String streename) {
		this.streename = streename;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	String streename;
   
	long pincode;
   
	String city;
	
	
}
