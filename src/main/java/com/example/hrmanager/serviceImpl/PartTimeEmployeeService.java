package com.example.hrmanager.serviceImpl;

import com.example.hrmanager.model.Employee;
import com.example.hrmanager.model.FullTimeEmployee;
import com.example.hrmanager.model.PartTimeEmployee;
import com.example.hrmanager.repository.PartTimeEmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PartTimeEmployeeService {

    private final PartTimeEmployeeRepository partTimeEmployeeRepository;

    public PartTimeEmployeeService(PartTimeEmployeeRepository partTimeEmployeeRepository) {
        this.partTimeEmployeeRepository = partTimeEmployeeRepository;
    }

    public List<PartTimeEmployee> getAll() {
        return partTimeEmployeeRepository.findAll().stream().filter(Employee::getActive).collect(Collectors.toList());
    }

    public void save(PartTimeEmployee partTimeEmployee) {
        partTimeEmployee.setSalaryPerHours(partTimeEmployee.calculatSalary());
        partTimeEmployeeRepository.save(partTimeEmployee);
    }

    public Optional<PartTimeEmployee> getById(long id) {
        return partTimeEmployeeRepository.findById(id);
    }

    public Boolean update(PartTimeEmployee partTimeEmployee) {
        Optional<PartTimeEmployee> partTimeEmployeeOptional = getById(partTimeEmployee.getId());
        if (partTimeEmployeeOptional.isEmpty()) {
            return false;
        }
        save(partTimeEmployee);
        return true;
    }
}
