package com.ppwa.user.application;

import com.ppwa.user.domain.model.User;
import com.ppwa.user.application.command.CreateUserCommand;
import com.ppwa.user.application.command.UpdateUserCommand;
import org.springframework.stereotype.Service;

@Service
public final class UserFactory {

    public User create(CreateUserCommand createUserCommand, String encodedPassword) {
        return new User(createUserCommand.getUsername(), encodedPassword, createUserCommand.getCountryCode(),
                createUserCommand.getPhoneNumber(), createUserCommand.isAdmin());
    }

    public User create(UpdateUserCommand updateUserCommand, String encodedPassword) {
        return new User(updateUserCommand.getUsername(), encodedPassword, updateUserCommand.getCountryCode(),
                updateUserCommand.getPhoneNumber(), updateUserCommand.isAdmin());
    }
}
