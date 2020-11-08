package com.ppwa.user.application.use_case;

import com.ppwa.user.domain.UserRepository;
import com.ppwa.user.domain.exception.UserNotFoundException;
import com.ppwa.user.domain.model.User;
import org.springframework.stereotype.Service;

@Service
public final class ReadUser {

    private final UserRepository userRepository;

    public ReadUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(String username) {
        return this.userRepository.findById(username).orElseThrow(() -> new UserNotFoundException("Invalid username"));
    }
}
