package com.scaler.naveen.splitwise.enums;

import java.util.Optional;
import java.util.stream.Stream;

public enum Category {
    EQUAL(1), PERCENT(2), EXACT_AMOUNT(3);

    private int value;

    Category(int code) {
        value = code;
    }

    public int code() {
        return value;
    }

    public static Optional<Category> fromCode(int code) {
        return Stream.of(values()).filter(x -> x.code() == code).findFirst();
    }

    public boolean is(Category status) {
        return value == status.value;
    }
}
