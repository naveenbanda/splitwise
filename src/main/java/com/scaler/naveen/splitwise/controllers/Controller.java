package com.scaler.naveen.splitwise.controllers;

import com.scaler.naveen.splitwise.models.expense.Expense;
import com.scaler.naveen.splitwise.models.expense.ExpenseDetails;
import com.scaler.naveen.splitwise.models.user.User;
import com.scaler.naveen.splitwise.models.user.UserDetails;
import com.scaler.naveen.splitwise.services.SplitwiseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/splitwise")
public class Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private SplitwiseService splitwiseService;

    @PostMapping("/add-user")
    public UserDetails addUser(@RequestBody User user) {
        try {
            return splitwiseService.addUser(user);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("get-user-details/{userId}")
    public UserDetails getUserDetails(@PathVariable("userId") Long userId) {
        try {
            return splitwiseService.getUserDetails(userId);
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/add-expense")
    public ExpenseDetails addExpense(@RequestBody Expense expense) {
        return splitwiseService.addExpense(expense);
    }

    @PutMapping("/update-expense")
    public ExpenseDetails updateExpense(@RequestBody Expense expense) {
        return splitwiseService.updateExpense(expense);
    }

}
