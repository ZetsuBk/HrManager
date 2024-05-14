package com.example.hrmanager.serviceImpl;

import com.example.hrmanager.model.Role;

public class SalaryCalculater {
    public static double getHourlySalaryPerRole(Role role){
        return switch (role){
            case MANAGER -> 30.0;
            case DEVELOPER -> 15.0;
            case TESTER -> 15.0;
            default -> 0.0;
        };
    }
}
