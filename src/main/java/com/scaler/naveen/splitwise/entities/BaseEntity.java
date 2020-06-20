package com.scaler.naveen.splitwise.entities;

import com.scaler.naveen.splitwise.enums.ExpenseStatus;
import com.scaler.naveen.splitwise.enums.PassBookStatus;
import com.scaler.naveen.splitwise.enums.SplitStatus;
import com.scaler.naveen.splitwise.enums.UserStatus;
import com.scaler.naveen.splitwise.models.bookkeeper.PassBook;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass
@Data
@NoArgsConstructor
public abstract class BaseEntity {

    @CreatedDate
    @Column(name="created_date")
    private LocalDateTime createdDate;

    @CreatedBy
    @Column(name="created_by", length=20)
    private Long createdBy;

    @LastModifiedDate
    @Column(name="updated_date")
    private LocalDateTime updatedDate;

    @LastModifiedBy
    @Column(name="updated_by", length=20)
    private Long updatedBy;

    @Column(name = "status", length = 3, columnDefinition = "tinyint(3)", nullable = false)
    private Integer status;

    public void setStatus(int status) {
        this.status = status;
    }

    public BaseEntity(int status) {
        this.status = status;
    }

    public SplitStatus getSplitStatus() {
        return SplitStatus.fromCode(this.getStatus()).get();
    }

    public ExpenseStatus getExpenseStatus() {
        return ExpenseStatus.fromCode(this.getStatus()).get();
    }

    public PassBookStatus getPassBookStatus() {
        return PassBookStatus.fromCode(this.getStatus()).get();
    }

    public UserStatus getUserStatus() {
        return UserStatus.fromCode(this.getStatus()).get();
    }


}
