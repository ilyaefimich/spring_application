package com.epam.spring.utils;

import com.epam.spring.domain.entity.EventEntity;
import com.epam.spring.domain.entity.UserEntity;

import java.util.Comparator;

public class UtilsComparator {

    public static Comparator eventsComparator = new Comparator<EventEntity>() {
        @Override
        public int compare(EventEntity object1, EventEntity object2) {
            return object1.getId() > object2.getId() ? 1 : -1;
        }
    };

    public static Comparator usersComparator = new Comparator<UserEntity>() {
        @Override
        public int compare(UserEntity object1, UserEntity object2) {
            return object1.getId() > object2.getId() ? 1 : -1;
        }
    };

}
