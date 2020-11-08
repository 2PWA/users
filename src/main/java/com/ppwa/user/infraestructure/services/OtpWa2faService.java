package com.ppwa.user.infraestructure.services;

import com.ppwa.user.domain.model.User;
import com.ppwa.user.infraestructure.exception.handler.CodeNotValidException;
import com.ppwa.user.infraestructure.model.CreateOtpMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public final class OtpWa2faService {

    @Value("${wa2fa.url}")
    private String wa2faUrl;

    private final RestTemplate restTemplate;

    public OtpWa2faService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String requestOtpCode(User user) {
        try {
            var requestBody = new CreateOtpMessage(user.getCountryCode(), user.getPhoneNumber());
            var requestUrl = wa2faUrl + "/otp";
            var httpEntity = new HttpEntity<>(requestBody, createHeaders());
            return restTemplate.postForEntity(requestUrl, httpEntity, String.class).getBody();
        } catch (Exception exception) {
            throw new CodeNotValidException();
        }
    }

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-api-key","");
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    public void createValidateRequest(String otpCode, String uuid) {
        try {
            var headers = createHeadersForValidation(otpCode);
            var entity = new HttpEntity<>( headers);
            var requestUrl = wa2faUrl + "/otp/" + uuid;
            restTemplate.postForEntity(requestUrl, entity, Void.class);
        } catch (Exception exception) {
            throw new CodeNotValidException();
        }
    }

    private HttpHeaders createHeadersForValidation(String otpCode) {
        HttpHeaders headers = createHeaders();
        headers.add("x-wa2fa-otp",otpCode);
        return headers;
    }
}
