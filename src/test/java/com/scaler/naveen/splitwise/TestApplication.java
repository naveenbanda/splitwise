package com.scaler.naveen.splitwise;

import com.scaler.naveen.splitwise.enums.Category;
import com.scaler.naveen.splitwise.models.expense.Expense;
import com.scaler.naveen.splitwise.models.expense.ExpenseDetails;
import com.scaler.naveen.splitwise.models.user.User;
import com.scaler.naveen.splitwise.models.user.UserDetails;
import org.junit.Test;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@ContextConfiguration
public class TestApplication extends AbstractTest{

    private static final Logger LOGGER = LoggerFactory.getLogger(TestApplication.class);

    @Test
    public void test() throws Exception{
        String uri = base.toString()+"add-user";

        User user1 = getRandomUser();
        LOGGER.info("User1: " + user1);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(mapToJson(user1))).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        UserDetails userDetails1 = mapFromJson(mvcResult.getResponse().getContentAsString(), UserDetails.class);
        LOGGER.info("UserDetails: " + userDetails1);

        checkUserWithUserDetails(user1, userDetails1);

        User user2 = getRandomUser();
        LOGGER.info("User2: " + user2);
        mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(mapToJson(user2))).andReturn();
        status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        UserDetails userDetails2 = mapFromJson(mvcResult.getResponse().getContentAsString(), UserDetails.class);
        LOGGER.info("UserDetails2: " + userDetails2);

        checkUserWithUserDetails(user2, userDetails2);

        User user3 = getRandomUser();
        LOGGER.info("User3: " + user3);
        mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(mapToJson(user3))).andReturn();
        status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        UserDetails userDetails3 = mapFromJson(mvcResult.getResponse().getContentAsString(), UserDetails.class);
        LOGGER.info("UserDetails3: " + userDetails3);

        checkUserWithUserDetails(user3, userDetails3);




        uri = base.toString()+"add-expense";
        List<Long> usersInExpense = new ArrayList<>();
        usersInExpense.add(userDetails1.getId());
        usersInExpense.add(userDetails2.getId());
        usersInExpense.add(userDetails3.getId());

        Expense expense1 = getRandomExpense(Category.EQUAL, userDetails1.getId(), usersInExpense);
        LOGGER.info("Expense1: " + expense1);
        mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(mapToJson(expense1))).andReturn();
        status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        ExpenseDetails expenseDetails1 = mapFromJson(mvcResult.getResponse().getContentAsString(), ExpenseDetails.class);
        LOGGER.info("ExpenseDetails1: " + expenseDetails1);

        checkExpenseWithExpenseDetails(expense1, expenseDetails1);


    }





}
