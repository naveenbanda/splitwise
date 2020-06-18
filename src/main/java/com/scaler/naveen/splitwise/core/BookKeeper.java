package com.scaler.naveen.splitwise.core;

import com.scaler.naveen.splitwise.entities.ExpenseEntity;
import com.scaler.naveen.splitwise.entities.SplitEntity;
import com.scaler.naveen.splitwise.enums.Category;
import com.scaler.naveen.splitwise.models.expense.Expense;
import lombok.Getter;

import java.util.List;

public abstract class BookKeeper {

    @Getter
    private Category category;

    public BookKeeper(Category category) {
        this.category = category;
        if (category != null)
            BookKeeperRegistry.register(this);
    }

    public List<SplitEntity> splitExpense(Long expenseId, Expense expense) {
        return null;
    }

}
