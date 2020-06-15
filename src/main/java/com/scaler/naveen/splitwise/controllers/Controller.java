package com.scaler.naveen.splitwise.controllers;

import com.scaler.naveen.splitwise.models.expense.Expense;
import com.scaler.naveen.splitwise.models.expense.ExpenseDetails;
import com.scaler.naveen.splitwise.models.user.User;
import com.scaler.naveen.splitwise.models.user.UserDetails;
import com.scaler.naveen.splitwise.services.SplitwiseService;
import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@Log4j
@RestController
@RequestMapping("/splitwise")
public class Controller {
    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private SplitwiseService splitwiseService;

    @PostMapping("/add-user")
    public UserDetails addUser(@RequestBody User user) {
        try {
            LOGGER.info("Add user data: " + user);
            UserDetails userDetails = splitwiseService.addUser(user);
            LOGGER.info("UserDetails: " + userDetails);
            return userDetails;
        } catch (Exception e) {
            LOGGER.error(e.getLocalizedMessage(), e.getStackTrace());
            return null;
        }
    }

    @GetMapping("get-user-details/{userId}")
    public UserDetails getUserDetails(@PathVariable("userId") Long userId) {
        try {
            LOGGER.info("Getting user details by id: " + userId);
            UserDetails userDetails =  splitwiseService.getUserDetails(userId);
            LOGGER.info("UserDetails: " + userDetails);
            return userDetails;
        } catch (Exception e) {
            LOGGER.error(e.getLocalizedMessage(), e.getStackTrace());
            return null;
        }
    }

    @PostMapping("/add-expense")
    public ExpenseDetails addExpense(@RequestBody Expense expense) {
        try {
            LOGGER.info("Adding expense with data: " + expense);
            ExpenseDetails expenseDetails = splitwiseService.addExpense(expense);
            LOGGER.info("ExpenseDetails: " + expenseDetails);
            return expenseDetails;
        } catch (Exception e) {
            LOGGER.error(e.getLocalizedMessage(), e.getStackTrace());
            return null;
        }
    }

    @PutMapping("/update-expense")
    public ExpenseDetails updateExpense(@RequestBody Expense expense) {
        try {
            LOGGER.info("Updating expense with data: " + expense);
            ExpenseDetails expenseDetails = splitwiseService.updateExpense(expense);
            LOGGER.info("ExpenseDetails: " + expenseDetails);
            return expenseDetails;
        } catch (Exception e) {
            LOGGER.error(e.getLocalizedMessage(), e.getStackTrace());
            return null;
        }
    }

}
