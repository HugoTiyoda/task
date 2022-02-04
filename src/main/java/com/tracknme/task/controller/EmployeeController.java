package com.tracknme.task.controller;

import com.tracknme.task.entity.Employee;
import com.tracknme.task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/employees")
public class EmployeeController {

    private final EmployeeService employeeDAO;

    @Autowired
    public EmployeeController(EmployeeService employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @PostMapping
    public void addEmployer(@RequestBody Employee employee) {
        employeeDAO.addNewEmployee(employee);
    }


    @GetMapping(path = "/all")
    public ResponseEntity<?> getAll(){
        return employeeDAO.getAll();
    }

    @GetMapping(path = "/byid/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") long id){
        return employeeDAO.getById(id);
    }

    @GetMapping(path = "/bycep/{employeeCep}")
    public ResponseEntity<?> getByCep(@PathVariable("employeeCep") String employeeCep) {
        return employeeDAO.getByCep(employeeCep);
    }

    @DeleteMapping(path = "/delete/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") Long employeeId) {
        employeeDAO.deleteEmployee(employeeId);
    }

    @PutMapping(path = "/{employeeId}")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee){
return new ResponseEntity<>(HttpStatus.OK);
    }


}
