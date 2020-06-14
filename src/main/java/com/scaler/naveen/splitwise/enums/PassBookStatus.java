package com.scaler.naveen.splitwise.enums;

import java.util.Optional;
import java.util.stream.Stream;

public enum  PassBookStatus {
    NEGATIVE(1), POSITIVE(2);

    private int value;

    PassBookStatus(int code) {
        value = code;
    }

    public int code() {
        return value;
    }

    public static Optional<PassBookStatus> fromCode(int code) {
        return Stream.of(values()).filter(x -> x.code() == code).findFirst();
    }

    public boolean is(PassBookStatus status) {
        return value == status.value;
    }
}
