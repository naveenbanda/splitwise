package com.scaler.naveen.splitwise.entities;

import com.scaler.naveen.splitwise.constants.TableName;
import com.scaler.naveen.splitwise.enums.Category;
import com.scaler.naveen.splitwise.enums.ExpenseStatus;
import com.scaler.naveen.splitwise.models.expense.Expense;
import com.scaler.naveen.splitwise.models.user.User;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = TableName.EXPENSE)
public class ExpenseEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private LocalDateTime expenseDate;

    @Column(name = "paid_by")
    private Long paidBy;

    @Column(name = "added_by")
    private Long addedBy;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "name")
    private BigDecimal totalAmount;

    public ExpenseEntity(String description, LocalDateTime expenseDate, Long paidBy, Long addedBy, Category category, BigDecimal totalAmount) {
        this.description = description;
        this.expenseDate = expenseDate;
        this.paidBy = paidBy;
        this.addedBy = addedBy;
        this.category = category;
        this.totalAmount = totalAmount;
        setStatus(ExpenseStatus.UNSETTLED.code());
    }

    public ExpenseEntity(Expense expense) {
        this.description = expense.getDescription();
        this.expenseDate = expense.getExpenseDate();
        this.paidBy = expense.getPaidBy();
        this.addedBy = expense.getAddedBy();
        this.category = expense.getCategory();
        this.totalAmount = expense.getTotalAmount();
        setStatus(ExpenseStatus.UNSETTLED.code());
    }
}
