package com.example.ReliaChallenge.service;
import com.example.ReliaChallenge.dto.Employee;

import java.util.List;
import java.util.Map;
public interface EmployeeService {
    List<Employee> getAllEmployeeList();

    Employee getEmployeeById(String id);

    List<Employee> getEmployeeBySearchName(String searchString);

    Integer getHighestSalaryOfEmployee();

    List<String> getTopTenHighestEarningEmployeeNames();

    Object createEmployee(Map<String, Object> employeeInput);

    Object deleteEmployee(String id);
}
