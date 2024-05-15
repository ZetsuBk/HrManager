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
@RequestMapping("/employees/partTime")
public class PartTimeEmployeeController {

    @Autowired
    private PartTimeEmployeeService partTimeEmployeeService;

    @GetMapping()
    public ResponseEntity<List<PartTimeEmployee>> getAll() {
        return new ResponseEntity<>(partTimeEmployeeService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody PartTimeEmployee employee) {
        partTimeEmployeeService.save(employee);
        return new ResponseEntity<>("Employee was add successfully", HttpStatus.OK);
    }

    @PutMapping
    ResponseEntity<String> update(@RequestBody PartTimeEmployee employee) {
        return partTimeEmployeeService.update(employee) ?
                new ResponseEntity<>("Employee was updated successfully ", HttpStatus.BAD_REQUEST) :
                new ResponseEntity<>("Employee not Exist ", HttpStatus.BAD_REQUEST);
    }


}