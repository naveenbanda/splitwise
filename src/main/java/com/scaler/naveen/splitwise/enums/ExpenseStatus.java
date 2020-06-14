package com.scaler.naveen.splitwise.enums;

import java.util.Optional;
import java.util.stream.Stream;

public enum ExpenseStatus {
    UNSETTLED(1), SETTLED(2);

    private int value;

    ExpenseStatus(int code) {
        value = code;
    }

    public int code() {
        return value;
    }

    public static Optional<ExpenseStatus> fromCode(int code) {
        return Stream.of(values()).filter(x -> x.code() == code).findFirst();
    }

    public boolean is(ExpenseStatus status) {
        return value == status.value;
    }
}
