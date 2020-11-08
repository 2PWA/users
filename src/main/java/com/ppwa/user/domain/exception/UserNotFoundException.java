package com.ppwa.user.domain.exception;

public class UserNotFoundException extends RuntimeException {

    public static final long serialVersionUID = 1L;

    public UserNotFoundException(String message) {
        super(message);
    }
}
