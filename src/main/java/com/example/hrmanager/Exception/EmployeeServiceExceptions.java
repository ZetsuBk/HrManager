package com.example.hrmanager.Exception;

public class EmployeeServiceExceptions extends Exception{
    public EmployeeServiceExceptions() {
        super();
    }

    public EmployeeServiceExceptions(String message) {
        super(message);
    }

    public EmployeeServiceExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeServiceExceptions(Throwable cause) {
        super(cause);
    }
}
