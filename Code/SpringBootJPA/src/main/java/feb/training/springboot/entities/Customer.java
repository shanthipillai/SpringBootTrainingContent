package feb.training.springboot.entities;

import org.hibernate.annotations.GeneratorType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="customerjpa")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerid;
	private String name;
	private Double salary;

	@JsonIgnore
	private String acctstatus = "Active";

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private String bankname = "HDFC";
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "area", column = @Column(name = "prem_area", nullable = false)),
			@AttributeOverride(name = "doorno", column = @Column(name = "prem_doorno", nullable = false)),
			@AttributeOverride(name = "city", column = @Column(name = "prem_city", nullable = false)),
			@AttributeOverride(name = "pincode", column = @Column(name = "prem_pincode", nullable = false)) })
	
	Address permanentaddress;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "area", column = @Column(name = "temp_area", nullable = false)),
		@AttributeOverride(name = "doorno", column = @Column(name = "temp_doorno", nullable = false)),
		@AttributeOverride(name = "city", column = @Column(name = "temp_city", nullable = false)),
		@AttributeOverride(name = "pincode", column = @Column(name = "temp_pincode", nullable = false)) })
	Address temporaryadress;
	
  @PrePersist
	public void setBankDetails()
	{
		if(bankname==null)
		{
			bankname="HDFC";
		}
		if(acctstatus==null)
		{
			acctstatus="Active";
		}
	}
}
