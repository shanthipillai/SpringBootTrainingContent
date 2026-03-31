package feb.training.springboot.dto;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeClientDTO {

    // Employee fields
    private Integer empid;
    private String empemail;
    private int companyexp; 
    private double billing;
    private String prjctname;

    // Client fields
    private Integer clientid;
    private String clientemail;
    private int clientexp;
}