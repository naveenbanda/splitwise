package com.scaler.naveen.splitwise.exceptions;

public class UserNotFoundException extends Exception {

    public UserNotFoundException(Long userId) {
        super(String.format("User with userId %d does not exists", userId));
    }
}
