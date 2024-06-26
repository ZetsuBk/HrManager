package com.example.hrmanager.serviceImpl;

import com.example.hrmanager.model.ContrateurEmployee;
import com.example.hrmanager.model.Employee;
import com.example.hrmanager.model.PartTimeEmployee;
import com.example.hrmanager.repository.ContrateurEmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContrateurEmployeeService {

    private final ContrateurEmployeeRepository contrateurEmployeeRepository;

    public ContrateurEmployeeService(ContrateurEmployeeRepository contrateurEmployeeRepository) {
        this.contrateurEmployeeRepository = contrateurEmployeeRepository;
    }

    public List<ContrateurEmployee> getAll() {
        return contrateurEmployeeRepository.findAll().stream().filter(Employee::getActive).collect(Collectors.toList());
    }

    public void save(ContrateurEmployee contrateurEmployee) {
        contrateurEmployee.setSalaryPerHours(contrateurEmployee.calculatSalary());
        contrateurEmployeeRepository.save(contrateurEmployee);
    }

    public Optional<ContrateurEmployee> getById(long id) {
        return contrateurEmployeeRepository.findById(id);
    }

    public Boolean update(ContrateurEmployee contrateurEmployee) {
        Optional<ContrateurEmployee> contrateurEmployeeOptional = getById(contrateurEmployee.getId());
        if (contrateurEmployeeOptional.isEmpty()) {
            return false;
        }
        save(contrateurEmployee);
        return true;
    }

}
