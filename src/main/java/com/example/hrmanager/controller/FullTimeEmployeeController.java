package com.example.hrmanager.controller;

import com.example.hrmanager.model.FullTimeEmployee;
import com.example.hrmanager.serviceImpl.FullTimeEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        fullTimeEmployeeService.save(employee);
        return new ResponseEntity<>("Employee was add successfully", HttpStatus.OK);
    }

    @PutMapping
    ResponseEntity<String> update(@RequestBody FullTimeEmployee employee) {
        return fullTimeEmployeeService.update(employee) ?
                new ResponseEntity<>("Employee was updated successfully ", HttpStatus.BAD_REQUEST) :
                new ResponseEntity<>("Employee not Exist ", HttpStatus.BAD_REQUEST);
    }


}
