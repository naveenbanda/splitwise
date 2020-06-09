package com.scaler.naveen.splitwise;

import com.scaler.naveen.splitwise.enums.Category;
import com.scaler.naveen.splitwise.exceptions.UserNotFoundException;
import com.scaler.naveen.splitwise.models.expense.EqualAmountExpense;
import com.scaler.naveen.splitwise.models.expense.Expense;
import com.scaler.naveen.splitwise.models.user.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookKeeper {

    private Map<Long, Expense> expenses;
    private Map<Long, User> users;
    private static BookKeeper INSTANCE;

//    public BookKeeper(List<Expense> expenses, List<User> users) {
//        this.expenses = expenses;
//        this.users = users;
//    }

    private BookKeeper() {
        this.expenses = new HashMap<>();
        this.users = new HashMap<>();
    }

    public static BookKeeper getInstance() {
        if (INSTANCE == null)
            INSTANCE = new BookKeeper();
        return INSTANCE;
    }

    public void addUser(User user) {
        this.users.put(user.getUId(), user);
    }

    public User getUser(Long uId) throws UserNotFoundException {
        if (! users.containsKey(uId)) {
            throw new UserNotFoundException("Cannot find user with uId: " + uId);
        }
        return users.get(uId);
    }

    //get expense by id

    //add expense
    // add user
    // show balances
    //show balance of a user
    //simplify expenses

    public void addExpense(String name, User createdBy, BigDecimal totalAmount, Category category) {
        // Factory Pattern
    }
}
