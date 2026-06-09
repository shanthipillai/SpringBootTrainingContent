package com.example.employee.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return service.getEmployee(id);
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return service.saveEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
    }
}