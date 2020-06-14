package com.scaler.naveen.splitwise.repositories;

import com.scaler.naveen.splitwise.entities.ExpenseEntity;
import com.scaler.naveen.splitwise.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @QueryHints(@QueryHint(name = "org.hibernate.cacheable", value = "true"))
    Optional<UserEntity> findByPhoneNumber(String phoneNumber);

}
