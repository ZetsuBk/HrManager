package com.example.hrmanager.serviceImpl;

import com.example.hrmanager.Exception.EmployeeServiceExceptions;
import com.example.hrmanager.model.ContrateurEmployee;
import com.example.hrmanager.model.Employee;
import com.example.hrmanager.model.FullTimeEmployee;
import com.example.hrmanager.model.PartimeEmployee;
import com.example.hrmanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployer(){
        return  employeeRepository.findAll().stream().filter(Employee::getActive).collect(Collectors.toList());
    }

    public List<FullTimeEmployee> getAllFullTimeEmployer(){
        return getAllEmployer()
                .stream()
                .filter(employee -> employee instanceof FullTimeEmployee)
                .map(employee -> (FullTimeEmployee) employee)
                .collect(Collectors.toList());
    }

    public void save(Employee employee) throws  EmployeeServiceExceptions{
        if(employee instanceof FullTimeEmployee || employee instanceof PartimeEmployee){
            employeeRepository.save(employee);
        }
        else {
            throw new EmployeeServiceExceptions("Invalid instance of Employee");
        }
    }
    public Optional<Employee> getById(Long id){
        return  employeeRepository.findById(id);
    }


}
