package com.example.ReliaChallenge.Config;
import com.example.ReliaChallenge.constants.EmployeeConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class webConfiguration {
    @Bean
    WebClient webClient() {

        WebClient webClient = WebClient.builder().baseUrl(EmployeeConstants.REST_API_BASE_URL)
                .defaultCookie("cookie-name", "cookie-value")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();

        return webClient;
    }
}
