package com.scaler.naveen.splitwise.models.bookkeeper;

import com.scaler.naveen.splitwise.enums.PassBookStatus;
import com.scaler.naveen.splitwise.models.user.User;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PassBook {
    private User user;
    private BigDecimal amount;
    private PassBookStatus passBookStatus;
}
