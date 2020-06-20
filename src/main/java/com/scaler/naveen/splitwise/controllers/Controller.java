package com.scaler.naveen.splitwise.controllers;

import com.scaler.naveen.splitwise.models.expense.Expense;
import com.scaler.naveen.splitwise.models.expense.ExpenseDetails;
import com.scaler.naveen.splitwise.models.user.User;
import com.scaler.naveen.splitwise.models.user.UserDetails;
import com.scaler.naveen.splitwise.services.SplitwiseService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/splitwise")
public class Controller {

    @Autowired
    private SplitwiseService splitwiseService;

    @PostMapping("/add-user")
    public UserDetails addUser(@RequestBody User user) {
        try {
            log.info("Add user data: " + user);
            UserDetails userDetails = splitwiseService.addUser(user);
            log.info("UserDetails: " + userDetails);
            return userDetails;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/get-user-details")
    public UserDetails getUserDetails(@RequestParam(name = "userId") Long userId) {
        try {
            log.info("Getting user details by id: " + userId);
            UserDetails userDetails =  splitwiseService.getUserDetails(userId);
            log.info("UserDetails: " + userDetails);
            return userDetails;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/add-expense")
    public ExpenseDetails addExpense(@RequestBody Expense expense) {
        try {
            log.info("Adding expense with data: " + expense);
            ExpenseDetails expenseDetails = splitwiseService.addExpense(expense);
            log.info("ExpenseDetails: " + expenseDetails);
            return expenseDetails;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("/update-expense")
    public ExpenseDetails updateExpense(@RequestBody Expense expense) {
        try {
            log.info("Updating expense with data: " + expense);
            ExpenseDetails expenseDetails = splitwiseService.updateExpense(expense);
            log.info("ExpenseDetails: " + expenseDetails);
            return expenseDetails;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
