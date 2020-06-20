package com.scaler.naveen.splitwise.entities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.scaler.naveen.splitwise.constants.TableName;
import com.scaler.naveen.splitwise.enums.UserStatus;
import com.scaler.naveen.splitwise.models.expense.Expense;
import com.scaler.naveen.splitwise.models.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@Entity
@Table(name = TableName.USER)
@NoArgsConstructor
public class UserEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    public UserEntity(String name, String email, String phoneNumber) {
        super();
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        setStatus(UserStatus.ACTIVE.code());
    }

    public UserEntity(User user) {
        super();
        setName(user.getName());
        setEmail(user.getEmail());
        setPhoneNumber(user.getPhoneNumber());
        setStatus(UserStatus.ACTIVE.code());
    }

}

