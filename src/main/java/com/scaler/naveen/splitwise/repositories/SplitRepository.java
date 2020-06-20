package com.scaler.naveen.splitwise.repositories;

import com.scaler.naveen.splitwise.entities.ExpenseEntity;
import com.scaler.naveen.splitwise.entities.SplitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SplitRepository extends JpaRepository<SplitEntity, Long> {

    List<SplitEntity> getAllByUserId(Long userId);
}