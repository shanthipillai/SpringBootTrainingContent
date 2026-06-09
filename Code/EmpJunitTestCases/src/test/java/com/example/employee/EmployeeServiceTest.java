package com.example.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    private EmployeeService service;

    @Test
    void testGetEmployee() {

        Employee employee =
                new Employee(1L,"Shanthi",50000);

        when(repository.findById(1L))
                .thenReturn(employee);

        Employee result =
                service.getEmployee(1L);

        assertEquals("Shanthi",
                result.getName());

        verify(repository).findById(1L);
    }

    @Test
    void testSaveEmployee() {

        Employee employee =
                new Employee(3L,"Madhuri",70000);

        when(repository.save(employee))
                .thenReturn(employee);

        Employee result =
                service.saveEmployee(employee);

        assertEquals("Madhuri",
                result.getName());

        verify(repository).save(employee);
    }

    @Test
    void testDeleteEmployee() {

        service.deleteEmployee(1L);

        verify(repository).deleteById(1L);
    }
}