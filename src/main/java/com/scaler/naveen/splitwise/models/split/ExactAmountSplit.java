package com.scaler.naveen.splitwise.models.split;

import com.scaler.naveen.splitwise.models.user.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExactAmountSplit extends Split {

    public ExactAmountSplit(User user) {
        super(user);
    }
}
