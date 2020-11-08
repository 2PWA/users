package com.ppwa.user.application.use_case;

import com.ppwa.user.application.command.DeleteUserCommand;
import com.ppwa.user.domain.UserRepository;
import com.ppwa.user.infraestructure.services.OtpWa2faService;
import org.springframework.stereotype.Service;

@Service
public final class DeleteUser {

    private final UserRepository userRepository;
    private final OtpWa2faService otpWa2faService;

    public DeleteUser(UserRepository userRepository, OtpWa2faService otpWa2faService) {
        this.userRepository = userRepository;
        this.otpWa2faService = otpWa2faService;
    }

    public void execute(String username, DeleteUserCommand deleteUserCommand) {
        otpWa2faService.createValidateRequest(deleteUserCommand.getOtpCode(), deleteUserCommand.getUuid());
        userRepository.deleteById(username);
    }
}
