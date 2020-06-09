package com.scaler.naveen.splitwise.models.expense;

import com.scaler.naveen.splitwise.enums.Category;
import com.scaler.naveen.splitwise.models.user.User;
import com.scaler.naveen.splitwise.models.split.Split;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class EqualExpense extends Expense {

    public EqualExpense(String name, LocalDate date, User addedBy, User paidBy, Category category) {
        super(name, date, addedBy, paidBy, category);
    }

    @Override
    public boolean validate() {
        super.validate();
        // Logic specific to equal expense
        return false;
    }

    @Override
    public void updateBalance() {
        List<Split> splits = getSplits();
        int size = splits.size();
        for (Split split: splits) {
            split.setAmount(getTotalAmount().divide(BigDecimal.valueOf(size), SCALE, ROUNDING_MODE));
        }
    }
}
