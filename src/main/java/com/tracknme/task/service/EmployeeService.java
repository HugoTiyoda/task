package com.tracknme.task.service;

import com.tracknme.task.CustomError.CustomError;
import com.tracknme.task.entity.Employee;
import com.tracknme.task.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
public class EmployeeService {



    private final EmployeeRepository employeeDAO;

    @Autowired
    public EmployeeService(EmployeeRepository employeeDAO) {
        this.employeeDAO = employeeDAO;
    }


    //getall
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(employeeDAO.findAll(), HttpStatus.OK);
    }

    //getById
    public ResponseEntity<?> getById(Long employeeId) {
        if (employeeDAO.findById(employeeId).isEmpty()){
            return new ResponseEntity<>(new CustomError("Employee Not Found Or doesn't exist"),HttpStatus.NOT_FOUND);
        } else
            return new ResponseEntity<>(employeeDAO.findById(employeeId), HttpStatus.OK);
    }


    //getByCEP
    public ResponseEntity<?> getByCep( String employeeCep) {
        if (employeeDAO.findByCep(employeeCep).isEmpty()){
            return new ResponseEntity<>(new CustomError("Employee with cep " + employeeCep +" Not Found Or doesn't exist"),HttpStatus.NOT_FOUND);
        } else
            return new ResponseEntity<>(employeeDAO.findByCep(employeeCep), HttpStatus.OK);
    }


    //post
    public void addNewEmployee(Employee employee) {
        employeeDAO.save(employee);
    }

    //delete
    public void deleteEmployee(Long employeeId){
        Employee employee = employeeDAO.findById(employeeId).orElseThrow(()->new IllegalStateException(
                "Employee with id " + employeeId + " doesn't exist")
        );
        employeeDAO.deleteById(employeeId);
    }

    //update
   @Transactional
    public void updateEmployee(Long employeeId,Integer age, String cep, String name){
        Employee employee = employeeDAO.findById(employeeId).orElseThrow(()->new IllegalStateException(
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
