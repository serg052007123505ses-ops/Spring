package com.sergey.spring.boot.springboot_data_jpa.service;

import com.sergey.spring.boot.springboot_data_jpa.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    void deleteEmployee(int employeeId);

    public List<Employee> findAllByName(String name);
}