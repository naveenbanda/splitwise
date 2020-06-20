package com.scaler.naveen.splitwise;

import com.scaler.naveen.splitwise.enums.Category;
import com.scaler.naveen.splitwise.models.expense.Expense;
import com.scaler.naveen.splitwise.models.expense.ExpenseDetails;
import com.scaler.naveen.splitwise.models.user.User;
import com.scaler.naveen.splitwise.models.user.UserDetails;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestApplication extends AbstractTest{

    @LocalServerPort
    protected int port;

    @Autowired
    private TestRestTemplate restTemplate;

    protected URL base;

    @Before
    public void setUp() throws MalformedURLException {
        base = new URL("http://localhost:" + port + "/splitwise/");
    }

    @Test
    public void test() throws Exception {
        String uri = base.toString()+"add-user";

        User user1 = getRandomUser();
        log.info("User1: " + user1);
        UserDetails userDetails1 = this.restTemplate.postForEntity(uri, user1, UserDetails.class).getBody();
        log.info("UserDetails1: " + userDetails1);
        checkUserWithUserDetails(user1, userDetails1);

        User user2 = getRandomUser();
        log.info("User2: " + user2);
        UserDetails userDetails2 = this.restTemplate.postForEntity(uri, user2, UserDetails.class).getBody();
        log.info("UserDetails2: " + userDetails2);
        checkUserWithUserDetails(user2, userDetails2);

        User user3 = getRandomUser();
        log.info("User3: " + user3);
        UserDetails userDetails3 = this.restTemplate.postForEntity(uri, user3, UserDetails.class).getBody();
        log.info("UserDetails3: " + userDetails3);
        checkUserWithUserDetails(user3, userDetails3);




        uri = base.toString()+"add-expense";
        List<Long> usersInExpense = new ArrayList<>();
        usersInExpense.add(userDetails1.getId());
        usersInExpense.add(userDetails2.getId());
        usersInExpense.add(userDetails3.getId());

        Expense expense1 = getRandomExpense(Category.EQUAL, userDetails1.getId(), usersInExpense);
        log.info("Expense1: " + expense1);
        ExpenseDetails expenseDetails1 = this.restTemplate.postForEntity(uri, expense1, ExpenseDetails.class).getBody();
        log.info("ExpenseDetails1: " + expenseDetails1);

        checkExpenseWithExpenseDetails(expense1, expenseDetails1);

        Expense expense2 = getRandomExpense(Category.EXACT_AMOUNT, userDetails2.getId(), usersInExpense);
        log.info("Expense2: " + expense2);
        ExpenseDetails expenseDetails2 = this.restTemplate.postForEntity(uri, expense2, ExpenseDetails.class).getBody();
        log.info("ExpenseDetails2: " + expenseDetails2);

        checkExpenseWithExpenseDetails(expense2, expenseDetails2);


        uri = base.toString()+"get-user-details";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri)
                .queryParam("userId", userDetails1.getId());
        userDetails1 = this.restTemplate.getForEntity(builder.build().encode().toUri(), UserDetails.class).getBody();
        log.info("UserDetails for user 1: " + userDetails1);

        builder = UriComponentsBuilder.fromHttpUrl(uri)
                .queryParam("userId", userDetails2.getId());
        userDetails2 = this.restTemplate.getForEntity(builder.build().encode().toUri(), UserDetails.class).getBody();
        log.info("UserDetails for user 2: " + userDetails2);

        builder = UriComponentsBuilder.fromHttpUrl(uri)
                .queryParam("userId", userDetails3.getId());
        userDetails3 = this.restTemplate.getForEntity(builder.build().encode().toUri(), UserDetails.class).getBody();
        log.info("UserDetails for user 3: " + userDetails3);

    }





}
