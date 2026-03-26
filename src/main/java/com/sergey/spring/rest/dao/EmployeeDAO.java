package com.sergey.spring.rest.dao;

import com.sergey.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    void deleteEmployee(int employeeId);
}
