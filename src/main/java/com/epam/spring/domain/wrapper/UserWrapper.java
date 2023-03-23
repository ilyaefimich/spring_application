package com.epam.spring.domain.wrapper;

import com.epam.spring.domain.entity.UserEntity;
import lombok.Data;

import java.util.List;

@Data
public class UserWrapper {

    private List<UserEntity> users;

}
