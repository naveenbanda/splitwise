package com.scaler.naveen.splitwise.models.split;

import com.scaler.naveen.splitwise.models.user.User;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public abstract class Split {
    private static long NEW_UID = 0;

    private User user;
    private BigDecimal amount;
    private String note;
    private long uId;

    public Split(User user) {
        setUser(user);
        setUId();
    }

    private void setUId() {
        this.setUId(NEW_UID++);
    }
}
