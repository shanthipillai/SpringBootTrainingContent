package com.example.employee;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.employee.controller.EmployeeController;
import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService service;

    @Test
    void testGetEmployees() throws Exception {

        List<Employee> employees = List.of(
                new Employee(1L, "Shanthi", 50000),
                new Employee(2L, "Ravi", 60000)
        );

        when(service.getAllEmployees()).thenReturn(employees);

        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Shanthi"))
                .andExpect(jsonPath("$[1].name").value("Ravi"));
    }
}