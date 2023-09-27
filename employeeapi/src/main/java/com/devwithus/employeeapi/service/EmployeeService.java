package com.devwithus.employeeapi.service;

import com.devwithus.employeeapi.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {


        List<Employee> findAll();
        Optional<Employee> findById(int id);
        Employee save(Employee emp);
        void deleteById(int id);

}
