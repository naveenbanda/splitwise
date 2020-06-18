package com.scaler.naveen.splitwise.services.impl;

import com.scaler.naveen.splitwise.controllers.Controller;
import com.scaler.naveen.splitwise.core.BookKeeper;
import com.scaler.naveen.splitwise.core.BookKeeperRegistry;
import com.scaler.naveen.splitwise.entities.ExpenseEntity;
import com.scaler.naveen.splitwise.entities.SplitEntity;
import com.scaler.naveen.splitwise.entities.UserEntity;
import com.scaler.naveen.splitwise.exceptions.UserAlreadyExistException;
import com.scaler.naveen.splitwise.exceptions.UserNotFoundException;
import com.scaler.naveen.splitwise.models.bookkeeper.PassBook;
import com.scaler.naveen.splitwise.models.expense.Expense;
import com.scaler.naveen.splitwise.models.expense.ExpenseDetails;
import com.scaler.naveen.splitwise.models.split.Split;
import com.scaler.naveen.splitwise.models.user.User;
import com.scaler.naveen.splitwise.models.user.UserDetails;
import com.scaler.naveen.splitwise.repositories.ExpenseRepository;
import com.scaler.naveen.splitwise.repositories.SplitRepository;
import com.scaler.naveen.splitwise.repositories.UserRepository;
import com.scaler.naveen.splitwise.services.SplitwiseService;
import com.scaler.naveen.splitwise.utils.EntityModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SplitwiseServiceImpl implements SplitwiseService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SplitwiseServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private SplitRepository splitRepository;

    public UserDetails addUser(User user) throws UserAlreadyExistException {
        Optional<UserEntity> userEntity = userRepository.findByPhoneNumber(user.getPhoneNumber());
        if (userEntity.isPresent()) {
            throw new UserAlreadyExistException(user.getPhoneNumber());
        }
        UserEntity newUserEntity = userRepository.save(new UserEntity(user));

        LOGGER.info("UserEntity: " + newUserEntity);
        return EntityModelMapper.map(newUserEntity, new ArrayList<>());
    }

    public UserDetails getUserDetails(Long userId) throws UserNotFoundException {
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        if (!userEntity.isPresent()) {
            throw new UserNotFoundException(userId);
        } else {
            LOGGER.info("UserEntity: " + userEntity.get());
            return  EntityModelMapper.map(userEntity.get(), getPassbook(userId));
        }
    }

    public ExpenseDetails addExpense(Expense expense) {
        ExpenseEntity expenseEntity = new ExpenseEntity(expense);
        expenseRepository.save(expenseEntity);
        BookKeeper bookKeeper = BookKeeperRegistry.getBookKeeper(expense.getCategory());
        List<SplitEntity> splitEntities = bookKeeper.splitExpense(expenseEntity.getId(), expense);
        splitRepository.saveAll(splitEntities);
        return EntityModelMapper.map(expenseEntity, splitEntities);
    }

    public ExpenseDetails updateExpense(Expense expense) {
        return null;
    }

    private List<PassBook> getPassbook(Long userId) {
        return null;
    }
}
