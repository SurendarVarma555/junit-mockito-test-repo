package com.devwithus.employeeapi.service.impl;

import com.devwithus.employeeapi.model.Employee;
import com.devwithus.employeeapi.repository.EmployeeRepository;
import com.devwithus.employeeapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }
    @Override
    public Employee findById(int id) {
        return this.employeeRepository.getById(id);
    }
    @Override
    public Employee save(Employee emp) {
        return this.employeeRepository.save(emp);
    }
    @Override
    public void deleteById(int id) {
        this.employeeRepository.deleteById(id);
    }
}
