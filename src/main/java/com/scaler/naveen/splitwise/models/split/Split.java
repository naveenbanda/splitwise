package com.scaler.naveen.splitwise.models.split;

import com.scaler.naveen.splitwise.enums.SplitStatus;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Split {
    public Long id;
    private Long userId;
    private BigDecimal amountShare;
    private BigDecimal percentageShare;
    private String note;
    private SplitStatus splitStatus;
}
