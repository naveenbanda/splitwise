package com.scaler.naveen.splitwise.core;

import com.scaler.naveen.splitwise.enums.Category;
import org.springframework.stereotype.Service;

@Service
public class ExactAmountBookKeeper extends BookKeeper {
    public ExactAmountBookKeeper() {
        super(Category.EXACT_AMOUNT);
    }
}
