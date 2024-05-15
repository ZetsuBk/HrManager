package com.example.hrmanager.repository;

import com.example.hrmanager.model.PartTimeEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartTimeEmployeeRepository extends JpaRepository<PartTimeEmployee,Long> {
}
