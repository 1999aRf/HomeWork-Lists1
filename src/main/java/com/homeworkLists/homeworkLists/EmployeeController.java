package com.homeworkLists.homeworkLists;

import com.homeworkLists.homeworkLists.Employee;
import com.homeworkLists.homeworkLists.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(path = "/add")
    @ResponseStatus(HttpStatus.OK)
    public Employee addEmployee(@RequestParam ("firstName") String firstName, @RequestParam ("lastName") String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping("/remove")
    @ResponseStatus(HttpStatus.OK)
    public Employee removeEmployee(@RequestParam ("firstName") String firstName, @RequestParam ("lastName") String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    @ResponseStatus(HttpStatus.OK)
    public Employee findEmployee(@RequestParam ("firstName") String firstName, @RequestParam ("lastName") String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}