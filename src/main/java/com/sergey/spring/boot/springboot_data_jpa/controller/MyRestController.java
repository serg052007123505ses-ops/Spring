package com.sergey.spring.boot.springboot_data_jpa.controller;

import com.sergey.spring.boot.springboot_data_jpa.entity.Employee;
import com.sergey.spring.boot.springboot_data_jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable("id") int id){
        Employee employee = employeeService.getEmployee(id);

        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable("id") int id){
        Employee employee = employeeService.getEmployee(id);
        employeeService.deleteEmployee(id);
        return "Deleted employee with id " + id + " successfully";
    }

    @GetMapping("/employee/name/{name}")
    public List<Employee> findAllByName(@PathVariable("name") String name){
        return employeeService.findAllByName(name);
    }
}