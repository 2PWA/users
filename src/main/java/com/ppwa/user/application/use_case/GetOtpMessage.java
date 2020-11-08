package com.ppwa.user.application.use_case;

import com.ppwa.user.domain.UserRepository;
import com.ppwa.user.domain.exception.UserNotFoundException;
import com.ppwa.user.domain.model.User;
import com.ppwa.user.infraestructure.services.OtpWa2faService;
import org.springframework.stereotype.Service;

@Service
public class GetOtpMessage {

    private final UserRepository userRepository;
    private final OtpWa2faService otpWa2faService;

    public GetOtpMessage(UserRepository userRepository, OtpWa2faService otpWa2faService) {
        this.userRepository = userRepository;
        this.otpWa2faService = otpWa2faService;
    }

    public String execute(String username) {
        User user = userRepository.findById(username).orElseThrow(() -> new UserNotFoundException("Invalid username"));
        return otpWa2faService.requestOtpCode(user);
    }
}
