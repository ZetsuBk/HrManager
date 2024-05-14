package com.example.hrmanager.model;


import com.example.hrmanager.serviceImpl.SalaryCalculater;
import jakarta.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee {

    private double workHoursPerDay;
    private double salaryPerYear;

    public FullTimeEmployee() {
        super();
    }

    public FullTimeEmployee(String name, Role role, Boolean active, double workHouresPerDay) {
        super(name, role, active);
        this.workHoursPerDay = workHouresPerDay;
        this.salaryPerYear = calculatSalary();
    }


    public double getWorkHoursPerDay() {
        return workHoursPerDay;
    }

    public void setWorkHoursPerDay(double workHouresPerDay) {
        this.workHoursPerDay = workHouresPerDay;
    }

    public double getSalaryPerYear() {
        return salaryPerYear;
    }

    public void setSalaryPerYear(double salaryPerYear) {
        this.salaryPerYear = salaryPerYear;
    }

    @Override
    public double calculatSalary() {
        int workDaysInYear = 260;
        return SalaryCalculater.getHourlySalaryPerRole(getRole()) * workHoursPerDay * workDaysInYear;
    }
}
