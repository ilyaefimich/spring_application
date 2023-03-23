package com.epam.spring.service;

import com.epam.spring.dao.impl.DefaultUserDao;
import com.epam.spring.domain.entity.UserEntity;
import com.epam.spring.utils.ItemsFromPages;
import com.epam.spring.utils.Validation;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserService {

    private static final Logger LOG = Logger.getLogger(UserService.class.getName());
    DefaultUserDao userDAO;
    Random ran = new Random();
    private final int userId = ran.nextInt(6) + 5;

    public UserService() {
    }

    public UserService(DefaultUserDao userDAO) {
        this.userDAO = userDAO;
    }

    public void setUserDAO(DefaultUserDao userDAO) {
        this.userDAO = userDAO;
    }

    public UserEntity getUserById(long userId) {
        if (!Validation.isUserIdIsValid(userId)) {
            LOG.log(Level.WARNING, "UserId is not valid {}", userId);
            throw new IllegalArgumentException();
        }
        LOG.log(Level.INFO, "Get user by id :{}", userId);
        return userDAO.getUserById(userId);
    }

    public Optional<UserEntity> getUserByEmail(String email) {
        if (!Validation.isEmailIsValid(email)) {
            LOG.log(Level.WARNING, "Email is not valid {}", email);
            throw new IllegalArgumentException();
        }
        LOG.log(Level.INFO, "Get user by email" + email);
        return userDAO.getUserByEmail(email);
    }

    public List<UserEntity> getUsersByName(String name, int pageSize, int pageNum) {
        if (!Validation.isUsersParametersIsValid(name, pageSize, pageNum)) {
            LOG.log(Level.WARNING, "Users parameters is not valid");
            throw new IllegalArgumentException();
        }
        List<UserEntity> userList = ItemsFromPages.getItemsFromPages(userDAO.getUsersByName(name), pageSize, pageNum);
        LOG.log(Level.INFO, "Get users by name" + name);
        return userList;
    }

    public UserEntity createUser(UserEntity userEntity) {
        if (!Validation.isUserValid(userEntity)) {
            LOG.log(Level.WARNING, String.format("userEntity is not valid"));
            throw new IllegalArgumentException();
        }
        userEntity.setId(userId);
        userDAO.createUser(userEntity);
        LOG.log(Level.INFO, "Created user: " + userEntity);
        return userEntity;
    }

    public UserEntity updateUser(UserEntity userEntity) {
        if (!Validation.isUserValid(userEntity)) {
            LOG.log(Level.WARNING, "userEntity is not valid");
            throw new IllegalArgumentException();
        }
        LOG.log(Level.INFO, "Updated user:" + userEntity);
        return userDAO.updateUser(userEntity);
    }

    public boolean deleteUser(long userId) {
        if (!Validation.isUserIdIsValid(userId)) {
            LOG.log(Level.WARNING, "userEntity is not valid");
            throw new IllegalArgumentException();
        }
        LOG.log(Level.INFO, "Deleted user:" + userId);
        return userDAO.deleteUser(userId);
    }
}
