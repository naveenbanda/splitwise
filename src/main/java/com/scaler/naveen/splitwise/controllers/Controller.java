package com.scaler.naveen.splitwise.controllers;

import com.scaler.naveen.splitwise.models.expense.Expense;
import com.scaler.naveen.splitwise.models.expense.ExpenseDetails;
import com.scaler.naveen.splitwise.models.user.User;
import com.scaler.naveen.splitwise.models.user.UserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/splitwise")
public class Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    @PostMapping("/add-user")
    public UserDetails addUser(@RequestBody User user) {
        return null;
    }

    @GetMapping("get-user-details/{userId}")
    public UserDetails getUserDetails(@PathVariable("userId") Long userId) {
        return null;
    }

    @PostMapping("/add-expense")
    public ExpenseDetails addExpense(@RequestBody Expense expense) {
        return null;
    }

    @PostMapping("/update-expense/{expenseId}")
    public ExpenseDetails updateExpense(@PathVariable("expenseId") Long expenseID, @RequestBody Expense expense) {
        return null;
    }

}
