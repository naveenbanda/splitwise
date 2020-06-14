package com.scaler.naveen.splitwise.repositories;

import com.scaler.naveen.splitwise.entities.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Long> {
}
