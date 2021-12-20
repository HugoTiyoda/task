package com.tracknme.task.controller;

import com.tracknme.task.entity.Employee;
import com.tracknme.task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public void addEmployer(@RequestBody Employee employee) {
        employeeService.addNewEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployer() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(path = "/byid={employeeId}")
    public Optional<Employee> getEmployeeById(@PathVariable("employeeId") Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @GetMapping(path = "/bycep={employeeCep}")
    public Optional<Employee> getByCep(@PathVariable("employeeCep") String employeeCep) {
        return employeeService.getByCep(employeeCep);
    }

    @DeleteMapping(path = "/delete={employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

    @PutMapping(path = "/{employeeId}")
    public void updateEmployee(
            @PathVariable("employeeId") Long employeeId,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) String cep,
            @RequestParam(required = false) String name
    ){employeeService.updateEmployee(employeeId,age,cep,name);}


}
