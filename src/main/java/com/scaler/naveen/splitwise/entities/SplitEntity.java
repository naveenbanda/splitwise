package com.scaler.naveen.splitwise.entities;

import com.scaler.naveen.splitwise.constants.TableName;
import com.scaler.naveen.splitwise.enums.SplitStatus;
import com.scaler.naveen.splitwise.models.user.User;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = TableName.SPLIT)
public class SplitEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "name")
    private String note;

    @Column(name = "expense_id")
    private Long expenseId;

    public SplitEntity(Long userId, BigDecimal amount, String note, Long expenseId) {
        this.userId = userId;
        this.amount = amount;
        this.note = note;
        this.expenseId = expenseId;
        setStatus(SplitStatus.UNPAID.code());
    }

}
