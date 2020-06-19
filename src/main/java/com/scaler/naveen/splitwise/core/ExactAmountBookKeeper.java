package com.scaler.naveen.splitwise.core;

import com.scaler.naveen.splitwise.entities.SplitEntity;
import com.scaler.naveen.splitwise.enums.Category;
import com.scaler.naveen.splitwise.enums.SplitStatus;
import com.scaler.naveen.splitwise.models.expense.Expense;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExactAmountBookKeeper extends BookKeeper {

    protected static final int SCALE = 2;
    protected static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;

    public ExactAmountBookKeeper() {
        super(Category.EXACT_AMOUNT);
    }

    @Override
    public List<SplitEntity> splitExpense(Long expenseId, Expense expense) {
        List<SplitEntity> splitEntities = new ArrayList<>();
        for (Long i: expense.getSplits().keySet()) {
            if (i.compareTo(expense.getPaidBy()) == 0) {
                splitEntities.add(new SplitEntity(i, expense.getSplits().get(i), "", expenseId, SplitStatus.PAID));
            } else {
                splitEntities.add(new SplitEntity(i, expense.getSplits().get(i), "", expenseId));
            }
        }
        return splitEntities;
    }
}
