package com.scaler.naveen.splitwise.repositories;

import com.scaler.naveen.splitwise.entities.ExpenseEntity;
import com.scaler.naveen.splitwise.entities.SplitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SplitRepository extends JpaRepository<SplitEntity, Long> {
}