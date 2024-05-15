package com.example.hrmanager.controller;

import com.example.hrmanager.model.PartTimeEmployee;
import com.example.hrmanager.serviceImpl.PartTimeEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees/fullTime")
public class PartTimeEmployeeController {

    @Autowired
    private PartTimeEmployeeService partTimeEmployeeService;

    @GetMapping()
    public ResponseEntity<List<PartTimeEmployee>> getAll() {
        return new ResponseEntity<>(partTimeEmployeeService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody PartTimeEmployee employee) {
        employee.setSalaryPerHours(employee.calculatSalary());
        partTimeEmployeeService.save(employee);
        return new ResponseEntity<>("Employee was add successfully", HttpStatus.OK);
    }

    @PutMapping
    ResponseEntity<String> update(@RequestBody PartTimeEmployee employee) {
        Optional<PartTimeEmployee> partTimeEmployeeOptional = partTimeEmployeeService.getById(employee.getId());
        if (partTimeEmployeeOptional.isEmpty()) {
            return new ResponseEntity<>("Employee not Exist ", HttpStatus.BAD_REQUEST);
        }
        partTimeEmployeeService.save(employee);
        return new ResponseEntity<>("Employee was updated successfully", HttpStatus.OK);


    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long id) {
        Optional<PartTimeEmployee> employeeOptional = partTimeEmployeeService.getById(id);
        if (employeeOptional.isEmpty()) {
            return new ResponseEntity<>("Employee not Exist ", HttpStatus.BAD_REQUEST);
        }
        PartTimeEmployee employee = employeeOptional.get();
        employee.setActive(false);
        partTimeEmployeeService.save(employee);
        return new ResponseEntity<>("Employee was deleted successfully", HttpStatus.OK);
    }
}