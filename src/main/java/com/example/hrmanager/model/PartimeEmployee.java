package com.example.hrmanager.model;

import com.example.hrmanager.serviceImpl.SalaryCalculater;
import jakarta.persistence.Entity;

@Entity
public class PartimeEmployee extends Employee {

    private int workHours;

    private double salaryPerHours;

    public PartimeEmployee() {
        super();
    }

    public PartimeEmployee(String name, Role role, Boolean active, int workHours) {
        super(name, role, active);
        this.workHours = workHours;
        this.salaryPerHours = calculatSalary();
    }


    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public double getSalaryPerHours() {
        return salaryPerHours;
    }

    public void setSalaryPerHours(double salaryPerHours) {
        this.salaryPerHours = salaryPerHours;
    }


    @Override
    public double calculatSalary() {
        return SalaryCalculater.getHourlySalaryPerRole(getRole()) * workHours;
    }
}
