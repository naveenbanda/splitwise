package com.scaler.naveen.splitwise.models.split;

import com.scaler.naveen.splitwise.enums.SplitStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class Split {
    public Long id;
    private Long userId;
    private BigDecimal amountShare;
    private BigDecimal percentageShare;
    private String note;
    private SplitStatus splitStatus;
    private Long expenseId;

    public Split(Long id, Long userId, BigDecimal amountShare, BigDecimal percentageShare, String note, SplitStatus splitStatus) {
        this.id = id;
        this.userId = userId;
        this.amountShare = amountShare;
        this.percentageShare = percentageShare;
        this.note = note;
        this.splitStatus = splitStatus;
    }
}
