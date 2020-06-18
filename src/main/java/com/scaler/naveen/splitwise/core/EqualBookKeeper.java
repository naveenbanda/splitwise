package com.scaler.naveen.splitwise.core;

import com.scaler.naveen.splitwise.entities.ExpenseEntity;
import com.scaler.naveen.splitwise.entities.SplitEntity;
import com.scaler.naveen.splitwise.enums.Category;
import com.scaler.naveen.splitwise.enums.SplitStatus;
import com.scaler.naveen.splitwise.models.expense.Expense;
import com.scaler.naveen.splitwise.models.split.Split;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class EqualBookKeeper extends BookKeeper {

    protected static final int SCALE = 2;
    protected static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;

    public EqualBookKeeper() {
        super(Category.EQUAL);
    }

    @Override
    public List<SplitEntity> splitExpense(Long expenseId, Expense expense) {
        List<SplitEntity> splitEntities = new ArrayList<>();
        BigDecimal amount = expense.getTotalAmount();
        BigDecimal shareAmount = amount.divide(BigDecimal.valueOf(expense.getSplits().keySet().size()), SCALE, ROUNDING_MODE);
        for (Long i: expense.getSplits().keySet()) {
            if (i.compareTo(expense.getPaidBy()) == 0) {
                splitEntities.add(new SplitEntity(i, shareAmount, "", expenseId, SplitStatus.PAID));
            } else {
                splitEntities.add(new SplitEntity(i, shareAmount, "", expenseId));
            }
        }
        return splitEntities;
    }

}
