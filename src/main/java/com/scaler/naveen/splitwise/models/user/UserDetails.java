package com.scaler.naveen.splitwise.models.user;

import com.scaler.naveen.splitwise.models.bookkeeper.PassBook;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Data
public class UserDetails {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private List<PassBook> passBooks = new ArrayList<>();

    public UserDetails(Long id, String name, String email, String phoneNumber, List<PassBook> passBooks) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.passBooks = passBooks;
    }

    public UserDetails() {

    }

}
