package com.scaler.naveen.splitwise.services;

import com.scaler.naveen.splitwise.exceptions.UserAlreadyExistException;
import com.scaler.naveen.splitwise.exceptions.UserNotFoundException;
import com.scaler.naveen.splitwise.models.expense.Expense;
import com.scaler.naveen.splitwise.models.expense.ExpenseDetails;
import com.scaler.naveen.splitwise.models.user.User;
import com.scaler.naveen.splitwise.models.user.UserDetails;

public interface SplitwiseService {
    public UserDetails addUser(User user) throws UserAlreadyExistException;

    public UserDetails getUserDetails(Long userId) throws UserNotFoundException;

    public ExpenseDetails addExpense(Expense expense);

    public ExpenseDetails updateExpense(Expense expense);
}
