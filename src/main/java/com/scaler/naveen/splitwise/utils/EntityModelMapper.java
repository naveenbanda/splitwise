package com.scaler.naveen.splitwise.utils;

import com.scaler.naveen.splitwise.entities.UserEntity;
import com.scaler.naveen.splitwise.models.bookkeeper.PassBook;
import com.scaler.naveen.splitwise.models.user.User;
import com.scaler.naveen.splitwise.models.user.UserDetails;
import org.modelmapper.ModelMapper;

import java.util.List;

public final class EntityModelMapper {
    private static ModelMapper modelMapper = new ModelMapper();

    public static UserDetails map(UserEntity userEntity, List<PassBook> passBooks) {
        UserDetails userDetails = modelMapper.map(userEntity, UserDetails.class);
        userDetails.setPassBooks(passBooks);
        return userDetails;
    }
}
