package com.ppwa.user.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import static java.util.Objects.requireNonNull;

@Entity
public final class User {

    @Id
    private String username;
    private String password;
    private String countryCode;
    private String phoneNumber;
    private boolean admin;

    public User() {
    }

    public User(String username, String password, String countryCode, String phoneNumber, boolean admin) {
        requireNonNull(username);
        requireNonNull(password);
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
