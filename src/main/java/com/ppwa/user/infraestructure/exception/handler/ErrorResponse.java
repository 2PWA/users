package com.ppwa.user.infraestructure.exception.handler;

import java.time.LocalDateTime;

public final class ErrorResponse {

    private final LocalDateTime timestamp;
    private final Integer status;
    private final String message;
    private final String request;
    private final String method;
    private final String error;

    ErrorResponse(String message, String request, String method, LocalDateTime timestamp, Integer status, String error) {
        this.message = message;
        this.request = request;
        this.method = method;
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getRequest() {
        return request;
    }

    public String getMethod() {
        return method;
    }

    public String getError() {
        return error;
    }
}
