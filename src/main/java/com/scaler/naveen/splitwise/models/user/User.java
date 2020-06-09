package com.scaler.naveen.splitwise.models.user;

import com.scaler.naveen.splitwise.models.expense.Expense;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class User {
    private static long NEW_UID = 0;

    private long uId;
    private String name;
    private String email;
    private String phoneNumber;
    private List<Expense> expenses;

    public User (String name, String phoneNumber, String email) {
        setUId();
        setName(name);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setExpenses(new ArrayList<>());
    }

    public void setUId() {
        this.setUId(NEW_UID++);
    }

}
