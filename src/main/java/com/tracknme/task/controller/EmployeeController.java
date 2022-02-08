package com.tracknme.task.controller;

import com.tracknme.task.entity.Employee;
import com.tracknme.task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<?> addEmployer(@RequestBody Employee employee) {
        return employeeService.addNewEmployee(employee);
    }


    @GetMapping(path = "/all")
    public ResponseEntity<?> getAll(Pageable pageable) {
        return employeeService.getAll(pageable);
    }

    @GetMapping(path = "/byid/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") long id) {
        return employeeService.getById(id);
    }

    @GetMapping(path = "/bycep/{employeeCep}")
    public ResponseEntity<?> getByCep(@PathVariable("employeeCep") String employeeCep) {
        return employeeService.getByCep(employeeCep);
    }

    @DeleteMapping(path = "/delete/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

    @PutMapping(path = "/{employeeId}")
    public ResponseEntity<?> updateEmployee(@PathVariable("employeeId") Long employeeId,
                                            @RequestBody Employee employee) {
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
