package com.scaler.naveen.splitwise.utils;

import com.scaler.naveen.splitwise.entities.ExpenseEntity;
import com.scaler.naveen.splitwise.entities.SplitEntity;
import com.scaler.naveen.splitwise.entities.UserEntity;
import com.scaler.naveen.splitwise.enums.SplitStatus;
import com.scaler.naveen.splitwise.models.bookkeeper.PassBook;
import com.scaler.naveen.splitwise.models.expense.ExpenseDetails;
import com.scaler.naveen.splitwise.models.split.Split;
import com.scaler.naveen.splitwise.models.user.User;
import com.scaler.naveen.splitwise.models.user.UserDetails;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public final class EntityModelMapper {
    private static ModelMapper modelMapper = new ModelMapper();

    public static UserDetails map(UserEntity userEntity, List<PassBook> passBooks) {
        UserDetails userDetails = modelMapper.map(userEntity, UserDetails.class);
        userDetails.setPassBooks(passBooks);
        return userDetails;
    }

    public static ExpenseDetails map(ExpenseEntity expenseEntity, List<SplitEntity> splitEntities) {
        ExpenseDetails expenseDetails = modelMapper.map(expenseEntity, ExpenseDetails.class);
        expenseDetails.setSplits(map(splitEntities));
        return expenseDetails;
    }

    public static List<Split> map(List<SplitEntity> splitEntities) {
        return splitEntities.stream().map(splitEntity -> map(splitEntity)).collect(Collectors.toList());
    }

    public static Split map(SplitEntity splitEntity) {
        Split split = modelMapper.map(splitEntity, Split.class);
        split.setSplitStatus(SplitStatus.fromCode(splitEntity.getStatus()).get());
        return split;
    }

}
