package com.scaler.naveen.splitwise.enums;

import java.util.Optional;
import java.util.stream.Stream;

public enum UserStatus {
    INACTIVE(1), ACTIVE(2);

    private int value;

    UserStatus(int code) {
        value = code;
    }

    public int code() {
        return value;
    }

    public static Optional<UserStatus> fromCode(int code) {
        return Stream.of(values()).filter(x -> x.code() == code).findFirst();
    }

    public boolean is(UserStatus status) {
        return value == status.value;
    }
}
