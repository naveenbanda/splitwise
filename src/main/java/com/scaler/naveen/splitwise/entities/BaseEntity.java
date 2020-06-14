package com.scaler.naveen.splitwise.entities;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class BaseEntity {

    @CreatedDate
    @Column(name="created_date", nullable = false)
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

}
