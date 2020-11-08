package com.ppwa.user.infraestructure.model;

public class CreateOtpMessage {

    private final String countryCode;
    private final String phoneNumber;

    public CreateOtpMessage(String countryCode, String phoneNumber) {
        this.countryCode = countryCode;
        this.phoneNumber = phoneNumber;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
