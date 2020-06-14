package com.scaler.naveen.splitwise.exceptions;

public class UserAlreadyExistException extends Exception {

    public UserAlreadyExistException(String phoneNumber) {
        super(String.format("User with phone number %s already exists", phoneNumber));
    }
}
