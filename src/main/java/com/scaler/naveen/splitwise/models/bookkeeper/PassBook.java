package com.scaler.naveen.splitwise.models.bookkeeper;

import com.scaler.naveen.splitwise.enums.PassBookStatus;
import com.scaler.naveen.splitwise.models.user.User;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PassBook {
    private Long userId;
    private Long splitId;
    private BigDecimal amount;
    private PassBookStatus passBookStatus;

    public PassBook(Long userId, Long splitId, BigDecimal amount, PassBookStatus passBookStatus) {
        this.userId = userId;
        this.splitId = splitId;
        this.amount = amount;
        this.passBookStatus = passBookStatus;
    }
}
