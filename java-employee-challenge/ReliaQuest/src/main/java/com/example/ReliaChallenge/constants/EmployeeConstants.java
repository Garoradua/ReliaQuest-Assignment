package com.example.ReliaChallenge.constants;

public class EmployeeConstants {
    public static final String REST_API_URI_GET_EMPLOYEES_BY_NAME ="/search/{searchString}";
    public static final String REST_API_URI_EMPLOYEE_ID ="/{id}";
    public static final String REST_API_URI_GET_HIGHEST_SALARY="/highestSalary";
    public static final String REST_API_URI_GET_TOP_TEN_EMPLOYEE_NAMES="/topTenHighestEarningEmployeeNames";


    public static final String REST_API_URI_GET_ALL_EMPLOYEES="/employees";
    public static final String REST_API_URI_GET_EMPLOYEE_BY_ID="/employee/";
    public static final String REST_API_URI_CREATE_EMPLOYEE="/create";
    public static final String REST_API_URI_DELETE_EMPLOYEE= "/delete/";

    public static final String REST_API_BASE_URL = "https://dummy.restapiexample.com/api/v1";
}
