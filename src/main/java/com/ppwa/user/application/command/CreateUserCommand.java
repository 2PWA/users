package com.ppwa.user.application.command;

public final class CreateUserCommand {

    private final String username;
    private final String password;
    private final String countryCode;
    private final String phoneNumber;
    private final boolean admin;

    public CreateUserCommand(String username, String password, String countryCode, String phoneNumber, boolean admin) {
        this.username = username;
        this.password = password;
        this.countryCode = countryCode;
        this.phoneNumber = phoneNumber;
        this.admin = admin;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
