package com.psicoschedule.psicoschedule.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("Usuário não existe");
    }
}
