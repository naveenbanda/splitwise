package com.scaler.naveen.splitwise.models.expense;

import com.scaler.naveen.splitwise.enums.Category;
import com.scaler.naveen.splitwise.models.split.Split;
import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class ExpenseDetails {
    protected static final int SCALE = 2;
    protected static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;

    private Long id;
    private String description;
    private LocalDateTime expenseDate;
    private Long paidBy;
    private Category category;
    private BigDecimal totalAmount;
    private Long addedBy;
    private List<Split> splits = new ArrayList<>();

    public ExpenseDetails(String description, LocalDateTime expenseDate, Long paidBy, Category category, BigDecimal totalAmount, Long addedBy, List<Split> splits) {
        this.description = description;
        this.expenseDate = expenseDate;
        this.paidBy = paidBy;
        this.category = category;
        this.totalAmount = totalAmount;
        this.addedBy = addedBy;
        this.splits = splits;
    }

}
