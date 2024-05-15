package com.example.hrmanager.serviceImpl;

import com.example.hrmanager.model.Employee;
import com.example.hrmanager.model.FullTimeEmployee;
import com.example.hrmanager.repository.FullTimeEmployeeRepository;
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
        return fullTimeEmployeeRepository.findAll().stream().filter(Employee::getActive).collect(Collectors.toList());
    }

    public void save(FullTimeEmployee fullTimeEmployee) {
        fullTimeEmployeeRepository.save(fullTimeEmployee);
    }

    public Optional<FullTimeEmployee> getById(long id) {
        return fullTimeEmployeeRepository.findById(id);
    }
}
