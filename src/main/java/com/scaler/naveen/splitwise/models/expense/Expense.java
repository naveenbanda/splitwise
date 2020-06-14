package com.scaler.naveen.splitwise.models.expense;

import com.scaler.naveen.splitwise.enums.Category;
import com.scaler.naveen.splitwise.models.user.User;
import com.scaler.naveen.splitwise.models.split.Split;
import com.scaler.naveen.splitwise.utils.Util;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Expense {
    protected static final int SCALE = 2;
    protected static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;

    private Long id;
    private String description;
    private LocalDateTime expenseDate;
    private Long paidBy;
    private Category category;
    private BigDecimal totalAmount;
    private Long addedBy;
    private Map<Long, BigDecimal> splits = new HashMap<>();

    public Expense(String description, LocalDateTime expenseDate, Long paidBy, Category category, BigDecimal totalAmount, Long addedBy, Map<Long, BigDecimal> splits) {
        this.description = description;
        this.expenseDate = expenseDate;
        this.paidBy = paidBy;
        this.category = category;
        this.totalAmount = totalAmount;
        this.addedBy = addedBy;
        this.splits = splits;
    }

    //    private Image image;
//    private Location location;

//    public boolean validate() {
//        // Common Logic
//        return Util.isApproxEqual(splits.stream().map(split -> split.getAmount()).reduce(BigDecimal.ZERO, (x, y) -> x.add(y)), totalAmount);
//        // Todo: precision problem. It is solved to two decimal places. Check again
//    }
//
//    public void setSplits (List<Split> splits) {
//        //validate split
//        setSplits(splits);
//    }
//
//    public void removeSplit(Split split) {
//        splits.remove(split);
//        updateBalance();
//    }
//
//    public abstract void updateBalance();

}
