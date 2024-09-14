package com.example.ReliaChallenge.controller;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.example.ReliaChallenge.constants.EmployeeConstants;
import com.example.ReliaChallenge.dto.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface EmployeeController {
    @GetMapping()
    ResponseEntity<List<Employee>> getAllEmployees() throws IOException;

    @GetMapping(EmployeeConstants.REST_API_URI_GET_EMPLOYEES_BY_NAME)
    ResponseEntity<List<Employee>> getEmployeesByNameSearch(@PathVariable String searchString);

    @GetMapping(EmployeeConstants.REST_API_URI_EMPLOYEE_ID)
    ResponseEntity<Employee> getEmployeeById(@PathVariable String id);

    @GetMapping(EmployeeConstants.REST_API_URI_GET_HIGHEST_SALARY)
    ResponseEntity<Integer> getHighestSalaryOfEmployees();

    @GetMapping(EmployeeConstants.REST_API_URI_GET_TOP_TEN_EMPLOYEE_NAMES)
    ResponseEntity<List<String>> getTopTenHighestEarningEmployeeNames();

    @PostMapping()
    ResponseEntity<Object> createEmployee(@RequestBody Map<String, Object> employeeInput);

    @DeleteMapping(EmployeeConstants.REST_API_URI_EMPLOYEE_ID)
    ResponseEntity<Object> deleteEmployeeById(@PathVariable String id);
}
