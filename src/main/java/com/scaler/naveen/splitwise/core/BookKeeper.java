package com.scaler.naveen.splitwise.core;

import com.scaler.naveen.splitwise.enums.Category;
import lombok.Getter;

public abstract class BookKeeper {

    @Getter
    private Category category;

    public BookKeeper(Category category) {
        this.category = category;
        if (category != null)
            BookKeeperRegistry.register(this);
    }
}
