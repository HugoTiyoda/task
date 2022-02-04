package com.tracknme.task.service;

import com.tracknme.task.entity.Employee;
import com.tracknme.task.Repository.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;
    public AutoCloseable autoCloseable;
    private EmployeeService underTest;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new EmployeeService(employeeRepository);

    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

//    @Test
//    void testGetAllEmployees() {
//        //when
//        underTest.getAllEmployees();
//        //then
//        verify(employeeRepository).findAll();
//    }


    @Test
    void addNewEmployee() {
        //given
        Employee test1 = new Employee(
                "maria",
                "7877000",
                20
        );
        //when
        underTest.addNewEmployee(test1);
        //then
        ArgumentCaptor<Employee> employeeArgumentCaptor = ArgumentCaptor.forClass(Employee.class);

      verify(employeeRepository).save(employeeArgumentCaptor.capture()); //capturando funcionario pego

        Employee capturedEmployee = employeeArgumentCaptor.getValue();
        assertThat(capturedEmployee).isEqualTo(test1);
    }

    @Test
    @Disabled
    void deleteEmployee(){

    }

    @Test
    @Disabled
    void updateEmployee() {
    }
}