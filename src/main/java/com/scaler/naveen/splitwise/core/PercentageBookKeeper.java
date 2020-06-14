package com.scaler.naveen.splitwise.core;

import com.scaler.naveen.splitwise.enums.Category;
import org.springframework.stereotype.Service;

@Service
public class PercentageBookKeeper extends BookKeeper {
    public PercentageBookKeeper() {
        super(Category.PERCENT);
    }
}
