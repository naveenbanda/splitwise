package com.scaler.naveen.splitwise;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.scaler.naveen.splitwise.enums.Category;
import com.scaler.naveen.splitwise.enums.SplitStatus;
import com.scaler.naveen.splitwise.models.expense.Expense;
import com.scaler.naveen.splitwise.models.expense.ExpenseDetails;
import com.scaler.naveen.splitwise.models.split.Split;
import com.scaler.naveen.splitwise.models.user.User;
import com.scaler.naveen.splitwise.models.user.UserDetails;
import com.scaler.naveen.splitwise.utils.Util;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Slf4j
public abstract class AbstractTest {

    protected static final int SCALE = 2;
    protected static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;

    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

    protected <T> T mapFromJson(String json, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, clazz);
    }

    protected User getRandomUser() throws JsonProcessingException {
        try {
            Faker faker = new Faker();
            User user = new User(faker.lordOfTheRings().character(), faker.internet().emailAddress(), faker.phoneNumber().phoneNumber());
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected Expense getRandomExpense(Category category, Long uId, List<Long> usersInExpense) throws JsonProcessingException {
        try {
            Faker faker = new Faker();
            BigDecimal amount = BigDecimal.valueOf(faker.number().randomDigit());
            Map<Long, BigDecimal> splits = getRandomSplits(category, usersInExpense, amount);
            Expense expense = new Expense(faker.witcher().quote(), LocalDateTime.now(), uId, category, amount, uId, splits);
            return expense;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Map<Long, BigDecimal> getRandomSplits(Category category, List<Long> usersInExpense, BigDecimal amount) {
        Faker faker = new Faker();
        Map<Long, BigDecimal> splits = new HashMap<>();

        switch (category) {
            case EQUAL:
                for (int i=0; i<usersInExpense.size(); i++) {
                    splits.put(usersInExpense.get(i), BigDecimal.ZERO);
                }
                return splits;
            case EXACT_AMOUNT:
                BigDecimal[] shareAmount = new BigDecimal[usersInExpense.size()];
                int total = amount.intValue();
                Random rand = new Random();
                for (int i = 0; i < shareAmount.length-1; i++) {
                    shareAmount[i] = BigDecimal.valueOf(rand.nextInt(total));
                    total -= shareAmount[i].intValue();
                }
                shareAmount[shareAmount.length-1] = BigDecimal.valueOf(total);
                for (int i=0; i<usersInExpense.size(); i++) {
                    splits.put(usersInExpense.get(i), shareAmount[i]);
                }
                return splits;
            case PERCENT:
                BigDecimal[] percentage = new BigDecimal[usersInExpense.size()];
                total = 100;
                rand = new Random();
                for (int i = 0; i < percentage.length-1; i++) {
                    percentage[i] = BigDecimal.valueOf(rand.nextInt(total));
                    total -= percentage[i].intValue();
                }
                percentage[percentage.length-1] = BigDecimal.valueOf(total);
                for (int i=0; i<usersInExpense.size(); i++) {
                    splits.put(usersInExpense.get(i), percentage[i]);
                }
                return splits;
            default:
                throw new RuntimeException("Category not handled: " + category);
        }
    }

    public void checkUserWithUserDetails(User user, UserDetails userDetails) {
        try {
            assertEquals(user.getName(), userDetails.getName());
            assertEquals(user.getEmail(), userDetails.getEmail());
            assertEquals(user.getPhoneNumber(), userDetails.getPhoneNumber());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkExpenseWithExpenseDetails(Expense expense, ExpenseDetails expenseDetails) {
        try {
            assertEquals(expense.getDescription(), expenseDetails.getDescription());
            assertEquals(expense.getExpenseDate(), expenseDetails.getExpenseDate());
            assertEquals(expense.getPaidBy(), expenseDetails.getPaidBy());
            assertEquals(expense.getCategory(), expenseDetails.getCategory());
            assertEquals(expense.getTotalAmount(), expenseDetails.getTotalAmount());
            assertEquals(expense.getAddedBy(), expenseDetails.getAddedBy());

            Map<Long, BigDecimal> splits = expense.getSplits();
            List<Split> expenseSplits = expenseDetails.getSplits();
            assertEquals(splits.size(), expenseSplits.size());
            Optional<Split> splitOfPaidBy = expenseSplits.stream().filter(split -> (split.getUserId().compareTo(expense.getPaidBy()) == 0)).findAny();
            assertTrue(splitOfPaidBy.isPresent());
            assertTrue(splitOfPaidBy.get().getSplitStatus().is(SplitStatus.PAID));

            switch (expense.getCategory()) {
                case EQUAL:
                    BigDecimal shareAmount = expense.getTotalAmount().divide(BigDecimal.valueOf(expense.getSplits().size()), SCALE, ROUNDING_MODE);
                    for (Split split : expenseDetails.getSplits()) {
                        assertTrue(Util.isApproxEqual(split.getAmountShare(), shareAmount));
                    }
                    break;
                case EXACT_AMOUNT:
                    for (Split split : expenseDetails.getSplits()) {
                        assertTrue(Util.isApproxEqual(split.getAmountShare(), expense.getSplits().get(split.getUserId())));
                    }
                    break;
                default:
                    throw new RuntimeException(String.format("Category %s not handled", expense.getCategory()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
