package com.homeworkLists.homeworkLists;

import Exceptions.EmployeeAlreadyAddedException;
import Exceptions.EmployeeNotFoundException;
import Exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> employees = new ArrayList<>();
    private static final int maxEmployees = 10;

    public Employee addEmployee(String firstName, String lastName) {
        if (employees.size() >= maxEmployees) {
            throw new EmployeeStorageIsFullException("Максимальное количество сотрудников достигнуто");
        }

        Employee newEmployee = new Employee(firstName, lastName);
        if (employees.contains(newEmployee)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже существует");
        }

        employees.add(newEmployee);
        return newEmployee;
    }

    public Employee removeEmployee(String firstName, String lastname) {
        Employee employeeToRemove = new Employee(firstName, lastname);
        if (!employees.remove(employeeToRemove)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employeeToRemove;
    }

    public Employee findEmployee(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }
}
