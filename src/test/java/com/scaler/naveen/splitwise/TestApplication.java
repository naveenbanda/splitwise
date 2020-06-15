package com.scaler.naveen.splitwise;

import com.scaler.naveen.splitwise.models.user.User;
import com.scaler.naveen.splitwise.models.user.UserDetails;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.MalformedURLException;
import java.net.URL;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestApplication extends AbstractTest{
    private static final Logger LOGGER = LoggerFactory.getLogger(TestApplication.class);

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
        LOGGER.info("User1: " + user1);
        UserDetails userDetails1 = this.restTemplate.postForEntity(uri, user1, UserDetails.class).getBody();
        LOGGER.info("UserDetails1: " + userDetails1);
        checkUserWithUserDetails(user1, userDetails1);

        User user2 = getRandomUser();
        LOGGER.info("User2: " + user2);
        UserDetails userDetails2 = this.restTemplate.postForEntity(uri, user2, UserDetails.class).getBody();
        LOGGER.info("UserDetails2: " + userDetails2);
        checkUserWithUserDetails(user2, userDetails2);

        User user3 = getRandomUser();
        LOGGER.info("User3: " + user3);
        UserDetails userDetails3 = this.restTemplate.postForEntity(uri, user3, UserDetails.class).getBody();
        LOGGER.info("UserDetails3: " + userDetails3);
        checkUserWithUserDetails(user3, userDetails3);


//
//
//        uri = base.toString()+"add-expense";
//        List<Long> usersInExpense = new ArrayList<>();
//        usersInExpense.add(userDetails1.getId());
//        usersInExpense.add(userDetails2.getId());
//        usersInExpense.add(userDetails3.getId());
//
//        Expense expense1 = getRandomExpense(Category.EQUAL, userDetails1.getId(), usersInExpense);
//        LOGGER.info("Expense1: " + expense1);
//        mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
//                .contentType(MediaType.APPLICATION_JSON_VALUE).content(mapToJson(expense1))).andReturn();
//        status = mvcResult.getResponse().getStatus();
//        assertEquals(200, status);
//        ExpenseDetails expenseDetails1 = mapFromJson(mvcResult.getResponse().getContentAsString(), ExpenseDetails.class);
//        LOGGER.info("ExpenseDetails1: " + expenseDetails1);
//
//        checkExpenseWithExpenseDetails(expense1, expenseDetails1);


    }





}
