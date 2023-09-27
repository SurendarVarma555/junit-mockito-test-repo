package com.devwithus.employeeapi.EmployeeServiceTest;

import com.devwithus.employeeapi.model.Employee;
import com.devwithus.employeeapi.repository.EmployeeRepository;
import com.devwithus.employeeapi.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest {
    @Mock
    private EmployeeRepository employeeRepository;
    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private Employee employee1;
    private Employee employee2;
    List<Employee> employeesList;

    @BeforeEach
    public void setUp (){
        employeesList = new ArrayList<>();
        employee1 = new Employee(1, "aaa", "bbb");
        employee2 = new Employee(2, "ccc", "ddd");
        employeesList.add(employee1);
        employeesList.add(employee2);
    }

    @BeforeEach
    public void tearDown (){
        employee1 = employee2 = null;
        employeesList = null;

    }

    @Test
    public void should_return_employee_list (){
        when(this.employeeRepository.findAll()).thenReturn(employeesList);
        List<Employee> employeeServiceAll = this.employeeService.findAll();
        assertEquals(employeesList, employeeServiceAll);
        verify(employeeRepository, times(1)).findAll();
        assertEquals(2, employeeServiceAll.size());
    }

    @Test
    public void findById_should_return_employee (){
        when(employeeRepository.getById(1)).thenReturn(employee1);
        assertThat(employeeService.findById(employee1.getId())).isEqualTo(employee1);
        verify(this.employeeRepository).getById(1);
    }

    @Test
    public void save_should_insert_new_employee (){
        when(employeeRepository.save(any())).thenReturn(employee1);
        employeeService.save(employee1);
        verify(employeeRepository, times(1)).save(employee1);
    }


    @Test
    public void deleteById_should_delete_employee(){
        this.employeeService.deleteById(1);
        verify(this.employeeRepository).deleteById(1);
    }


}
