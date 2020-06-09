package com.scaler.naveen.splitwise.models.split;

import com.scaler.naveen.splitwise.models.user.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EqualSplit extends Split {

    public EqualSplit(User user) {
        super(user);
    }
}
