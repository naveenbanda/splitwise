package com.scaler.naveen.splitwise.models.expense;

import com.scaler.naveen.splitwise.enums.Category;
import com.scaler.naveen.splitwise.models.user.User;
import com.scaler.naveen.splitwise.models.split.Split;
import com.scaler.naveen.splitwise.utils.Util;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public abstract class Expense {
    protected static final int SCALE = 2;
    protected static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;

    private static long NEW_UID = 0;

    private long uId;
    private String name;
    private LocalDate date;
    private User addedBy;
    private User paidBy;
    private Category category;
    private BigDecimal totalAmount;
    private List<Split> splits; // Runtime Polymorphism

//    private Image image;
//    private Location location;


    public Expense (String name, LocalDate date, User addedBy, User paidBy, Category category) {
        // Todo: Use Builder Pattern
        setUId();
        setName(name);
        setDate(date);
        setAddedBy(addedBy);
        setPaidBy(paidBy);
        setCategory(category);
    }

    private void setUId() {
        this.setUId(NEW_UID++);
    }

    public boolean validate() {
        // Common Logic
        return Util.isApproxEqual(splits.stream().map(split -> split.getAmount()).reduce(BigDecimal.ZERO, (x, y) -> x.add(y)), totalAmount);
        // Todo: precision problem. It is solved to two decimal places. Check again
    }

    public void setSplits (List<Split> splits) {
        //validate split
        setSplits(splits);
    }

    public void removeSplit(Split split) {
        splits.remove(split);
        updateBalance();
    }

    public abstract void updateBalance();

}
