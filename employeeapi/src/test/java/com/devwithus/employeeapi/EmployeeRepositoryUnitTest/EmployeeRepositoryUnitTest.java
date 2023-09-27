package com.devwithus.employeeapi.EmployeeRepositoryUnitTest;

import com.devwithus.employeeapi.model.Employee;
import com.devwithus.employeeapi.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({MockitoExtension.class, SpringExtension.class})
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepositoryUnitTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void init(){
        ArrayList<Employee> list= new ArrayList<Employee>();
        list.add(new Employee(1,"Suren","Varma"));
        list.add(new Employee(2,"Rakesh","Reddy"));
        list.add(new Employee(3,"Suresh","Yadav"));


    }

    @Test
    void findAll_should_return_employee_list(){
        //when
        List<Employee> empployees =
                this.employeeRepository.findAll();
        //then
        assertEquals(3,this.employeeRepository.findAll().size());
    }
    @Test
    void findById_should_return_employee(){

        // When
        Optional<Employee> employee = this.employeeRepository.findById(2);
        // Then
        assertTrue(employee.isPresent());
    }

//    @Test
//    void save_should_insert_new_employee() {
//        // Given
//        Employee newEmployee = new Employee();
//        newEmployee.setFirstName("FIRST_NAME");
//        newEmployee.setLastName("LAST_NAME");
//        // When
//        Employee persistedEmployee = this.employeeRepository.save(newEmployee);
//        // Then
//        assertNotNull(persistedEmployee);
//        assertEquals(5, persistedEmployee.getId());
//    }
    @Test
    void save_should_update_existing_employee(){
        //Given
        Employee existingEmp = new Employee();
        existingEmp.setId(15);
        existingEmp.setFirstName("aaa");
        existingEmp.setLastName("bbb");
        //when
        Employee updatedEmp=this.employeeRepository.save(existingEmp);
        //then
        assertNotNull(updatedEmp);
        assertEquals("aaa",updatedEmp.getFirstName());
        assertEquals("bbb",updatedEmp.getLastName());
    }

    @Test
    void deleteById_should_delete_employee(){
        //when
        this.employeeRepository.deleteById(2);
        Optional<Employee> employeebyId = this.employeeRepository.findById(2);
        //then
        assertFalse(employeebyId.isPresent());


    }

}
