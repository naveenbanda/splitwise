package com.scaler.naveen.splitwise.core;

import com.scaler.naveen.splitwise.enums.Category;
import org.springframework.stereotype.Service;

@Service
public class EqualBookKeeper extends BookKeeper {
    public EqualBookKeeper() {
        super(Category.EQUAL);
    }
}
