package com.example.hrmanager.serviceImpl;

import com.example.hrmanager.model.Employee;
import com.example.hrmanager.model.FullTimeEmployee;
import com.example.hrmanager.repository.FullTimeEmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FullTimeEmployeeService {
    private final FullTimeEmployeeRepository fullTimeEmployeeRepository;

    public FullTimeEmployeeService(FullTimeEmployeeRepository fullTimeEmployeeRepository) {
        this.fullTimeEmployeeRepository = fullTimeEmployeeRepository;
    }

    public List<FullTimeEmployee> getAll() {
        return fullTimeEmployeeRepository.findAllByActiveTrue();
    }

    public void save(FullTimeEmployee fullTimeEmployee) {
        fullTimeEmployee.setSalaryPerYear(fullTimeEmployee.calculatSalary());
        fullTimeEmployeeRepository.save(fullTimeEmployee);
    }

    public Optional<FullTimeEmployee> getById(long id) {
        return fullTimeEmployeeRepository.findById(id);
    }

    public Boolean update(FullTimeEmployee fullTimeEmployee){
        Optional<FullTimeEmployee> fullTimeEmployeeOptional = getById(fullTimeEmployee.getId());
        if (fullTimeEmployeeOptional.isEmpty()) {
            return false;
        }
        save(fullTimeEmployee);
        return true;

    }

}
