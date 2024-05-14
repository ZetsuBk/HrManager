package com.example.hrmanager.model;

import jakarta.persistence.Entity;

@Entity
public class ContrateurEmployee extends PartimeEmployee {
    private int contraDurationInDays;

    private double salaryPerContra;

    public ContrateurEmployee() {
        super();
    }

    public ContrateurEmployee(String name, Role role, Boolean active, int workHours, int contraDurationInDays) {
        super(name, role, active, workHours);
        this.contraDurationInDays = contraDurationInDays;
        salaryPerContra = calculatSalary();
    }


    public double getSalaryPerContra() {
        return salaryPerContra;
    }

    public void setSalaryPerContra(double salaryPerContra) {
        this.salaryPerContra = salaryPerContra;
    }

    public int getContraDurationInDays() {
        return contraDurationInDays;
    }

    public void setContraDurationInDays(int contraDurationInDays) {
        this.contraDurationInDays = contraDurationInDays;
    }

    @Override
    public double calculatSalary() {
        return super.calculatSalary() * contraDurationInDays;
    }
}
