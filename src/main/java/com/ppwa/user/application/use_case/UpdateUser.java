package com.ppwa.user.application.use_case;

import com.ppwa.user.application.UserFactory;
import com.ppwa.user.application.command.UpdateUserCommand;
import com.ppwa.user.domain.UserRepository;
import org.springframework.stereotype.Service;

@Service
public final class UpdateUser {

    private final UserFactory userFactory;
    private final UserRepository userRepository;

    public UpdateUser(UserFactory userFactory, UserRepository userRepository) {
        this.userFactory = userFactory;
        this.userRepository = userRepository;
    }

    public void execute(UpdateUserCommand updateUserCommand, String encodedPassword) {
        var user = this.userFactory.create(updateUserCommand, encodedPassword);
        this.userRepository.save(user);
    }
}
