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
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping({"/",""})
    public ResponseEntity<List<Employee>> getAll(){
        return new ResponseEntity<>(employeeService.getAllEmployer(), HttpStatus.OK) ;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long id) {
        return  employeeService.delete(id) ?
                new ResponseEntity<>("Employee was deleted successfully ", HttpStatus.BAD_REQUEST) :
                new ResponseEntity<>("Employee not Exist ", HttpStatus.BAD_REQUEST);
    }
}
