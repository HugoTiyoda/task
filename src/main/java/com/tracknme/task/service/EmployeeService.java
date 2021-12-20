package com.tracknme.task.service;

import com.tracknme.task.entity.Employee;
import com.tracknme.task.entity.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {


    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //getAll
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();

    }

    //getById
    public Optional<Employee> getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->new IllegalStateException(
                "Employee with id " + employeeId + " doesn't exist")
        );
        return employeeRepository.findById(employeeId);
    }

    //getByCEP
    public Optional<Employee> getByCep(String employeeCep) {
       Optional<Employee> cepExist = employeeRepository.findByCep(employeeCep);

        if (cepExist.isEmpty()){
            throw new IllegalStateException( "Employee with CEP " + employeeCep + " doesn't exist");
        }
        return employeeRepository.findByCep(employeeCep);
    }

    //post
    public void addNewEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    //delete
    public void deleteEmployee(Long employeeId){
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->new IllegalStateException(
                "Employee with id " + employeeId + " doesn't exist")
        );
        employeeRepository.deleteById(employeeId);
    }

    //update
   @Transactional
    public void updateEmployee(Long employeeId,Integer age, String cep, String name){
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->new IllegalStateException(
                "Employee with id " + employeeId + " doesn't exist")
                );
        if (name!=null && name.length()>0 && !Objects.equals(employee.getName(),name)){
            employee.setName(name);

        }   if (cep!=null && cep.length()>0 && !Objects.equals(employee.getCep(),cep)){
            employee.setCep(cep);

        }if (age!=null && !age.equals(0) && !Objects.equals(employee.getAge(),age)){
            employee.setAge(age);
        }



    }

}
