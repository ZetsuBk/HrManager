package com.example.hrmanager.repository;

import com.example.hrmanager.model.FullTimeEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FullTimeEmployeeRepository extends JpaRepository<FullTimeEmployee,Long> {
}
