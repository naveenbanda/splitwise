package com.scaler.naveen.splitwise.models.split;

import com.scaler.naveen.splitwise.models.user.User;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PrecentSplit extends Split {

    private BigDecimal percentage;

    public PrecentSplit(User user) {
        super(user);
    }
}
