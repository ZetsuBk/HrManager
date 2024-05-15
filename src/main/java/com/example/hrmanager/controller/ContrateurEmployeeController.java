package com.example.hrmanager.controller;

import com.example.hrmanager.model.ContrateurEmployee;
import com.example.hrmanager.serviceImpl.ContrateurEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees/contrateur")
public class ContrateurEmployeeController {

    @Autowired
    private ContrateurEmployeeService contrateurEmployeeService;

    @GetMapping()
    public ResponseEntity<List<ContrateurEmployee>> getAll() {
        return new ResponseEntity<>(contrateurEmployeeService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody ContrateurEmployee employee) {
        contrateurEmployeeService.save(employee);
        return new ResponseEntity<>("Employee was add successfully", HttpStatus.OK);
    }

    @PutMapping
    ResponseEntity<String> update(@RequestBody ContrateurEmployee employee) {
        return contrateurEmployeeService.update(employee) ?
                new ResponseEntity<>("Employee was updated successfully ", HttpStatus.BAD_REQUEST) :
                new ResponseEntity<>("Employee not Exist ", HttpStatus.BAD_REQUEST);
    }


}
