package com.scaler.naveen.splitwise.models.expense;

import com.scaler.naveen.splitwise.enums.Category;
import com.scaler.naveen.splitwise.models.user.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EqualAmountExpense extends Expense {

    public EqualAmountExpense(String name, LocalDate date, User addedBy, User paidBy, Category category) {
        super(name, date, addedBy, paidBy, category);
    }

    @Override
    public void updateBalance() {

    }
}
