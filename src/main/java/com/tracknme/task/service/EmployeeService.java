package com.tracknme.task.service;

import com.tracknme.task.CustomError.ResourceNotFoundException;
import com.tracknme.task.Repository.EmployeeRepository;
import com.tracknme.task.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EmployeeService {


    private final EmployeeRepository employeeDAO;

    @Autowired
    public EmployeeService(EmployeeRepository employeeDAO) {
        this.employeeDAO = employeeDAO;
    }


    //getall
    public ResponseEntity<?> getAll(Pageable pageable) {
        return new ResponseEntity<>(employeeDAO.findAll(pageable), HttpStatus.OK);
    }

    //getById
    public ResponseEntity<?> getById(Long employeeId) {
        verifyIfIdExists(employeeId);
        return new ResponseEntity<>(employeeDAO.findById(employeeId), HttpStatus.OK);
    }


    //getByCEP
    public ResponseEntity<?> getByCep(String employeeCep) {
        verifyIfCepExists(employeeCep);
        return new ResponseEntity<>(employeeDAO.findByCep(employeeCep), HttpStatus.OK);
    }


    //post
    public ResponseEntity<?> addNewEmployee(Employee employee) {
        return new ResponseEntity<>(employeeDAO.save(employee), HttpStatus.CREATED);
    }

    //delete
    public void deleteEmployee(Long employeeId) {
        verifyIfIdExists(employeeId);
        employeeDAO.deleteById(employeeId);
    }

    //update
    @Transactional
    public ResponseEntity<?> updateEmployee(Employee employee) {
     return new ResponseEntity<>(employeeDAO.save(employee), HttpStatus.OK);
    }

    private void verifyIfIdExists(Long id) {
        if (employeeDAO.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("Employee with id " + id + " Not found");
        }
    }

    private void verifyIfCepExists(String employeeCep) {
        if (employeeDAO.findByCep(employeeCep).isEmpty()) {
            throw new ResourceNotFoundException("Employee with CEP " + employeeCep + " Not found");
        }
    }
}
