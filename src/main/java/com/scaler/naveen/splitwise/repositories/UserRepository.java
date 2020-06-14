package com.scaler.naveen.splitwise.repositories;

import com.scaler.naveen.splitwise.entities.ExpenseEntity;
import com.scaler.naveen.splitwise.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
