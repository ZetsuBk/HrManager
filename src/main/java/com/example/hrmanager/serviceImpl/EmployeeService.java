package com.example.hrmanager.serviceImpl;

import com.example.hrmanager.Exception.EmployeeServiceExceptions;
import com.example.hrmanager.model.Employee;
import com.example.hrmanager.model.FullTimeEmployee;
import com.example.hrmanager.model.PartTimeEmployee;
import com.example.hrmanager.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployer() {
        return employeeRepository.findAll().stream().filter(Employee::getActive).collect(Collectors.toList());
    }


    public void save(Employee employee) throws EmployeeServiceExceptions {
        if (employee instanceof FullTimeEmployee || employee instanceof PartTimeEmployee) {
            employeeRepository.save(employee);
        } else {
            throw new EmployeeServiceExceptions("Invalid instance of Employee");
        }
    }

    public Optional<Employee> getById(Long id) {
        return employeeRepository.findById(id);
    }


}
