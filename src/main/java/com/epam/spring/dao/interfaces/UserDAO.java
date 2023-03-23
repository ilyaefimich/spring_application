package com.epam.spring.dao.interfaces;

import com.epam.spring.domain.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserDAO {

    UserEntity getUserById(long userId);

    Optional<UserEntity> getUserByEmail(String email);

    List<UserEntity> getUsersByName(String name);

    void createUser(UserEntity userEntity);

    UserEntity updateUser(UserEntity userEntity);

    boolean deleteUser(long userId);

}
