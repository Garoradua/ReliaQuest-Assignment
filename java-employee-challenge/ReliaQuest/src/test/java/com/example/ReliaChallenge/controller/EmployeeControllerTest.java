package com.example.ReliaChallenge.controller;

import com.example.ReliaChallenge.RqChallengeApplicationTest;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import com.example.ReliaChallenge.utils.MockDataGenerator;
import com.example.ReliaChallenge.constants.EmployeeConstants;
import com.example.ReliaChallenge.dto.EmployeeByIdResponseDTO;
import com.example.ReliaChallenge.dto.EmployeeListResponseDTO;
import com.example.ReliaChallenge.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@ContextConfiguration
public class EmployeeControllerTest extends RqChallengeApplicationTest {
    @InjectMocks
    private EmployeeServiceImpl employeeService;
    @MockBean
    private WebClient webClient;
    @Mock
    private WebClient.Builder webClientBuilder;
    @Mock
    private WebClient.RequestHeadersUriSpec RequestHeadersUriSpec;
    @Mock
    private WebClient.RequestHeadersSpec requestHeaderSpec;
    @Mock
    private WebClient.RequestBodyUriSpec requestBodyUriSpec;
    @Mock
    private WebClient.RequestBodySpec requestBodySpec;
    @Mock
    private WebClient.ResponseSpec responseSpec;

    @Test
    public void testGetAllEmployeeListSuccess() throws Exception {
        when(webClient.get()).thenReturn(RequestHeadersUriSpec);
        when(RequestHeadersUriSpec.uri(anyString())).thenReturn(requestHeaderSpec);
        when(requestHeaderSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(EmployeeListResponseDTO.class))
                .thenReturn(Mono.just(MockDataGenerator.getEmployeeListResponseDTO()));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/").contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().is2xxSuccessful());
    }

    @Test
    public void testGetAllEmployeeListFailure() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/").contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().is5xxServerError());
    }

    @Test
    public void testGetEmployeesByNameSuccess() throws Exception {
        when(webClient.get()).thenReturn(RequestHeadersUriSpec);
        when(RequestHeadersUriSpec.uri(anyString())).thenReturn(requestHeaderSpec);
        when(requestHeaderSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(EmployeeListResponseDTO.class))
                .thenReturn(Mono.just(MockDataGenerator.getEmployeeListResponseDTO()));
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(EmployeeConstants.REST_API_URI_GET_EMPLOYEES_BY_NAME, "Gourav")
                .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().is2xxSuccessful());
    }

    @Test
    public void testGetEmployeesByNameFailure() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(EmployeeConstants.REST_API_URI_GET_EMPLOYEES_BY_NAME, "Gourav")
                .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().is5xxServerError());
    }

    @Test
    public void testGetEmployeeByIdGetApiSuccess() throws Exception {
        when(webClient.get()).thenReturn(RequestHeadersUriSpec);
        when(RequestHeadersUriSpec.uri(anyString())).thenReturn(requestHeaderSpec);
        when(requestHeaderSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(EmployeeByIdResponseDTO.class))
                .thenReturn(Mono.just(MockDataGenerator.getEmployeeByIdResponseDTO()));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(EmployeeConstants.REST_API_URI_EMPLOYEE_ID, "id")
                .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().is2xxSuccessful());
    }

    @Test
    public void testGetEmployeeByIdGetApiFailure() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(EmployeeConstants.REST_API_URI_EMPLOYEE_ID, "id")
                .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().is5xxServerError());
    }

    @Test
    public void testGetHighestSalaryOfEmployeesSuccess() throws Exception {
        when(webClient.get()).thenReturn(RequestHeadersUriSpec);
        when(RequestHeadersUriSpec.uri(anyString())).thenReturn(requestHeaderSpec);
        when(requestHeaderSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(EmployeeListResponseDTO.class))
                .thenReturn(Mono.just(MockDataGenerator.getEmployeeListResponseDTO()));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(EmployeeConstants.REST_API_URI_GET_HIGHEST_SALARY)
                .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().is2xxSuccessful());
    }

    @Test
    public void testGetHighestSalaryOfEmployeesFailure() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(EmployeeConstants.REST_API_URI_GET_HIGHEST_SALARY)
                .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().is5xxServerError());
    }

    @Test
    public void testGetTopTenHighestEarningEmployeeNamesSuccess() throws Exception {
        when(webClient.get()).thenReturn(RequestHeadersUriSpec);
        when(RequestHeadersUriSpec.uri(anyString())).thenReturn(requestHeaderSpec);
        when(requestHeaderSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(EmployeeListResponseDTO.class))
                .thenReturn(Mono.just(MockDataGenerator.getEmployeeListResponseDTO()));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(EmployeeConstants.REST_API_URI_GET_TOP_TEN_EMPLOYEE_NAMES)
                .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().is2xxSuccessful());
    }

    @Test
    public void testGetTopTenHighestEarningEmployeeNamesFailure() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(EmployeeConstants.REST_API_URI_GET_TOP_TEN_EMPLOYEE_NAMES)
                .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().is5xxServerError());
    }

    @Test
    public void testCreateEmployeePostApiSuccess() throws Exception {
        Map<String, Object> map = new HashMap<>();
        when(webClient.post()).thenReturn(requestBodyUriSpec);
        when(requestBodyUriSpec.uri(anyString())).thenReturn(requestBodySpec);
        when(requestBodySpec.header(any(), any())).thenReturn(requestBodySpec);
        when(requestBodySpec.body(any())).thenReturn(requestHeaderSpec);
        when(requestHeaderSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(Map.class)).thenReturn(Mono.just(map));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/").content("{}")
                .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().is2xxSuccessful());
    }

    @Test
    public void testCreateEmployeePostFailure() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/").content("{}")
                .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().is5xxServerError());
    }

    @Test
    public void testdeleteEmployeeByIdDeleteSuccess() throws Exception {
        when(webClient.delete()).thenReturn(RequestHeadersUriSpec);
        when(RequestHeadersUriSpec.uri(anyString())).thenReturn(requestHeaderSpec);
        when(requestHeaderSpec.header(any(), any())).thenReturn(requestHeaderSpec);
        when(requestHeaderSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(Object.class)).thenReturn(Mono.just(MockDataGenerator.getEmployee()));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(EmployeeConstants.REST_API_URI_EMPLOYEE_ID, "id")
                .content("{}").contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().is2xxSuccessful());
    }

    @Test
    public void testdeleteEmployeeByIdDeleteFailure() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(EmployeeConstants.REST_API_URI_EMPLOYEE_ID, "1")
                .content("{}").contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().is5xxServerError());
    }

}
