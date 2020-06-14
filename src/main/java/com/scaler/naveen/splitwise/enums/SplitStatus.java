package com.scaler.naveen.splitwise.enums;

import java.util.Optional;
import java.util.stream.Stream;

public enum  SplitStatus {
    UNPAID(1), PAID(2);

    private int value;

    SplitStatus(int code) {
        value = code;
    }

    public int code() {
        return value;
    }

    public static Optional<SplitStatus> fromCode(int code) {
        return Stream.of(values()).filter(x -> x.code() == code).findFirst();
    }

    public boolean is(SplitStatus status) {
        return value == status.value;
    }
}
