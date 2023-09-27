package com.devwithus.employeeapi.controller;

import com.devwithus.employeeapi.model.Employee;
import com.devwithus.employeeapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    List<Employee> getAll() {
        return this.employeeService.findAll();
    }
    @GetMapping(value = "/{id}")
    Employee getById(@PathVariable int id) {
        return this.employeeService.findById(id);
    }
    @PostMapping
    Employee add(@RequestBody Employee emp) {
        return this.employeeService.save(emp);
    }
    @PutMapping
    Employee update(@RequestBody Employee emp) {
        return this.employeeService.save(emp);
    }
    @DeleteMapping(value = "/{id}")
    void delete(@PathVariable int id) {
        this.employeeService.deleteById(id);
    }
}
