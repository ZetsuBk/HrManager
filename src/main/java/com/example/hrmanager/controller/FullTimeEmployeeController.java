package com.example.hrmanager.controller;

import com.example.hrmanager.Exception.EmployeeServiceExceptions;
import com.example.hrmanager.model.Employee;
import com.example.hrmanager.model.FullTimeEmployee;
import com.example.hrmanager.serviceImpl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees/fullTime")
public class FullTimeEmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping()
    public ResponseEntity<List<FullTimeEmployee>> getAll(){
        return  new ResponseEntity<>(employeeService.getAllFullTimeEmployer(), HttpStatus.OK) ;
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody FullTimeEmployee employee){
        employee.setSalaryPerYear(employee.calculatSalary());
        try {
            employeeService.save(employee);
            return new ResponseEntity<>("Employee was add successfully",HttpStatus.OK);
        } catch (EmployeeServiceExceptions e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    ResponseEntity<String>  update(@RequestBody FullTimeEmployee employee){
        Optional<Employee> employeeOptional  = employeeService.getById(employee.getId());
        if(employeeOptional.isEmpty()){
            return  new ResponseEntity<>("Employee not Exist ",HttpStatus.BAD_REQUEST);
        }
        try {
            employeeService.save(employee);
            return  new ResponseEntity<>("Employee was updated successfully",HttpStatus.OK);
        } catch (EmployeeServiceExceptions e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long id){
        Optional<Employee> employeeOptional = employeeService.getById(id);
        if(employeeOptional.isEmpty()){
            return  new ResponseEntity<>("Employee not Exist ",HttpStatus.BAD_REQUEST);
        }
        try {
            Employee employee = employeeOptional.get();
            employee.setActive(false);
            employeeService.save(employee);
            return  new ResponseEntity<>("Employee was deleted successfully",HttpStatus.OK);
        } catch (EmployeeServiceExceptions e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
