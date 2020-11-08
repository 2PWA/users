package com.ppwa.user.infraestructure;

import com.ppwa.user.application.use_case.GetOtpMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/otp")
public class OtpController {

    private final GetOtpMessage getOTPMessage;

    public OtpController(GetOtpMessage getOTPMessage) {
        this.getOTPMessage = getOTPMessage;
    }

    @GetMapping
    public String getOtpMessage(Principal principal) {
        return getOTPMessage.execute(principal.getName());
    }
}
