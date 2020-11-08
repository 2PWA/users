package com.ppwa.user.application.command;

public final class DeleteUserCommand {

    private final String uuid;
    private final String otpCode;

    public DeleteUserCommand(String uuid, String otpCode) {
        this.uuid = uuid;
        this.otpCode = otpCode;
    }

    public String getUuid() {
        return uuid;
    }

    public String getOtpCode() {
        return otpCode;
    }
}
