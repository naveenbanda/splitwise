package com.scaler.naveen.splitwise.core;

import com.scaler.naveen.splitwise.enums.Category;
import com.scaler.naveen.splitwise.exceptions.ServiceAlreadyRegisteredException;

import java.util.HashMap;
import java.util.Map;

public final class BookKeeperRegistry {
    private final static Map<Category, BookKeeper> KEEPERS = new HashMap<>();

    public static void register(BookKeeper bookKeeper) {
        Category key = bookKeeper.getCategory();
        if (KEEPERS.containsKey(key))
            throw new RuntimeException(String.format("BookKeeper(%s): Already registered", key));
        //throw new ServiceAlreadyRegisteredException(BookKeeper.class, key);
        KEEPERS.put(key, bookKeeper);
    }

    public static BookKeeper getBookKeeper(Category key) {
        if (!KEEPERS.containsKey(key))
            throw new RuntimeException(String.format("BookKeeper(%s): Not found", key));
        return KEEPERS.get(key);
    }
}
