package com.example.hrmanager.controller;

import com.example.hrmanager.model.FullTimeEmployee;
import com.example.hrmanager.serviceImpl.FullTimeEmployeeService;
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
    private FullTimeEmployeeService fullTimeEmployeeService;

    @GetMapping()
    public ResponseEntity<List<FullTimeEmployee>> getAll() {
        return new ResponseEntity<>(fullTimeEmployeeService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody FullTimeEmployee employee) {
        employee.setSalaryPerYear(employee.calculatSalary());
        fullTimeEmployeeService.save(employee);
        return new ResponseEntity<>("Employee was add successfully", HttpStatus.OK);
    }

    @PutMapping
    ResponseEntity<String> update(@RequestBody FullTimeEmployee employee) {
        Optional<FullTimeEmployee> fullTimeEmployeeOptional = fullTimeEmployeeService.getById(employee.getId());
        if (fullTimeEmployeeOptional.isEmpty()) {
            return new ResponseEntity<>("Employee not Exist ", HttpStatus.BAD_REQUEST);
        }
        fullTimeEmployeeService.save(employee);
        return new ResponseEntity<>("Employee was updated successfully", HttpStatus.OK);


    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long id) {
        Optional<FullTimeEmployee> employeeOptional = fullTimeEmployeeService.getById(id);
        if (employeeOptional.isEmpty()) {
            return new ResponseEntity<>("Employee not Exist ", HttpStatus.BAD_REQUEST);
        }
        FullTimeEmployee employee = employeeOptional.get();
        employee.setActive(false);
        fullTimeEmployeeService.save(employee);
        return new ResponseEntity<>("Employee was deleted successfully", HttpStatus.OK);
    }
}
