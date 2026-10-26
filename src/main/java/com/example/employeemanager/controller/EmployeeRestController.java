package com.example.employeemanager.controller;

import com.example.employeemanager.model.Employee;
import com.example.employeemanager.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/api/employees", "/api/employees/"})
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping({"", "/"})
    public List<Employee> getAll(@RequestParam(value = "keyword", required = false) String keyword) {
        return employeeService.searchEmployees(keyword);
    }

    @GetMapping({"/{id}", "/{id}/"})
    public ResponseEntity<Employee> getById(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping({"", "/"})
    public ResponseEntity<?> create(@Valid @RequestBody Employee employee) {
        if (employeeService.isEmailRegistered(employee.getEmail(), null)) {
            return ResponseEntity.badRequest().body("This email is already registered");
        }
        Employee saved = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping({"/{id}", "/{id}/"})
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody Employee employee) {
        if (employeeService.getEmployeeById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        if (employeeService.isEmailRegistered(employee.getEmail(), id)) {
            return ResponseEntity.badRequest().body("This email is already registered");
        }
        employee.setId(id);
        Employee updated = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping({"/{id}", "/{id}/"})
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (employeeService.getEmployeeById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.noContent().build();
    }
}
