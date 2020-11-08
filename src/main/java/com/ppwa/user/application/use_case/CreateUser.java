package com.ppwa.user.application.use_case;

import com.ppwa.user.domain.UserRepository;
import com.ppwa.user.application.UserFactory;
import com.ppwa.user.application.command.CreateUserCommand;
import org.springframework.stereotype.Service;

@Service
public final class CreateUser {

    private final UserFactory userFactory;
    private final UserRepository userRepository;

    public CreateUser(UserFactory userFactory, UserRepository userRepository) {
        this.userFactory = userFactory;
        this.userRepository = userRepository;
    }

    public void execute(CreateUserCommand createUserCommand, String encodedPassword) {
        var user = this.userFactory.create(createUserCommand, encodedPassword);
        this.userRepository.save(user);
    }
}
