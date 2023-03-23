package com.epam.spring.dao.impl;

import com.epam.spring.dao.interfaces.UserDAO;
import com.epam.spring.domain.entity.UserEntity;
import com.epam.spring.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.epam.spring.namespace.Constants.USER;

public class DefaultUserDao implements UserDAO {

    @Autowired
    Repository repository;

    @Override
    public UserEntity getUserById(long userId) {
        UserEntity user = null;
        for (Map.Entry<String, Object> entry : repository.getRepository().entrySet()) {
            if (entry.getKey().contains(USER + Long.toString(userId))) {
                user = (UserEntity) repository.getRepository().get(USER + Long.toString(userId));
            }
        }
        return user;
    }

    @Override
    public Optional<UserEntity> getUserByEmail(String email) {
        for (Map.Entry<String, Object> entry : repository.getRepository().entrySet()) {
            UserEntity user = (UserEntity) entry.getValue();
            if (user.getEmail().equals(email)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<UserEntity> getUsersByName(String name) {
        List<UserEntity> listUser = new ArrayList<>();
        for (Map.Entry<String, Object> entry : repository.getRepository().entrySet()) {
            UserEntity user = (UserEntity) entry.getValue();
            if (user.getName().contains(name)) {
                listUser.add(user);
            }
        }
        return listUser;
    }

    @Override
    public void createUser(UserEntity userEntity) {
        repository.put(USER + userEntity.getId(), userEntity);
    }

    @Override
    public UserEntity updateUser(UserEntity userEntity) {
        UserEntity updatedUser = null;
        if (repository.getRepository().containsKey(USER + userEntity.getId())) {
            updatedUser = (UserEntity) repository.get(USER + userEntity.getId());

            updatedUser.setName(userEntity.getName());

            updatedUser.setEmail(userEntity.getEmail());

            repository.put(USER + userEntity.getId(), userEntity);
        }
        return updatedUser;
    }

    @Override
    public boolean deleteUser(long userId) {
        if (repository.getRepository().containsKey(USER + Long.toString(userId))) {
            repository.delete(USER + Long.toString(userId));
            return true;
        }
        return false;
    }
}
