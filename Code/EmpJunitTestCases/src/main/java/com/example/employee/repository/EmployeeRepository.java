package com.example.employee.repository;

import java.util.List;

import com.example.employee.model.Employee;

public interface EmployeeRepository {

    List<Employee> findAll();

    Employee findById(Long id);

    Employee save(Employee employee);

    void deleteById(Long id);
}