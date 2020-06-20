package com.scaler.naveen.splitwise.entities;

import com.scaler.naveen.splitwise.constants.TableName;
import com.scaler.naveen.splitwise.enums.SplitStatus;
import com.scaler.naveen.splitwise.models.expense.Expense;
import com.scaler.naveen.splitwise.models.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = TableName.SPLIT)
@NoArgsConstructor
public class SplitEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "amount_share")
    private BigDecimal amountShare;

    @Column(name = "name")
    private String note;

    @Column(name = "expense_id")
    private Long expenseId;

    public SplitEntity(Long userId, BigDecimal amount, String note, Long expenseId) {
        super(SplitStatus.UNPAID.code());
        this.userId = userId;
        this.amountShare = amount;
        this.note = note;
        this.expenseId = expenseId;
    }

    public SplitEntity(Long userId, BigDecimal amount, String note, Long expenseId, SplitStatus splitStatus) {
        super(splitStatus.code());
        this.userId = userId;
        this.amountShare = amount;
        this.note = note;
        this.expenseId = expenseId;
    }

}
