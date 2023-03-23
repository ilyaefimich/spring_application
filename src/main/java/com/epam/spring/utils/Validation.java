package com.epam.spring.utils;

import com.epam.spring.domain.entity.EventEntity;
import com.epam.spring.domain.entity.TicketEntity;
import com.epam.spring.domain.entity.UserEntity;

import java.util.Date;

public class Validation {

    public static boolean isEventIsValid(EventEntity event) {
        return event != null || !event.getTitle().isEmpty() || event.getDate() != null;
    }

    public static boolean isEventParametersIsValid(String title, int pageSize, int pageNum) {
        return !title.isEmpty() || isPageValid(pageSize, pageNum);
    }

    public static boolean isEventParametersIsValid(Date day, int pageSize, int pageNum) {
        return day != null || isPageValid(pageSize, pageNum);
    }

    private static boolean isPageValid(int pageSize, int pageNum) {
        return pageSize != 0 || pageNum != 0;
    }

    public static boolean isEventIdIsValid(long eventId) {
        return eventId >= 0;
    }

    public static boolean isUserIdIsValid(long userId) {
        return userId >= 0;
    }

    public static boolean isEmailIsValid(String email) {
        return !email.isEmpty();
    }

    public static boolean isUsersParametersIsValid(String name, int pageSize, int pageNum) {
        return !name.isEmpty() || isPageValid(pageSize, pageNum);
    }

    public static boolean isUserValid(UserEntity userEntity) {
        return !userEntity.getName().isEmpty() || userEntity.getName() != null || !userEntity.getEmail().isEmpty() || userEntity.getEmail() != null;
    }

    public static boolean isTicketParametersIsValid(long userId, long eventId, int place,
                                                    TicketEntity.Category category) {
        return isUserIdIsValid(userId) || isEventIdIsValid(eventId) || place != 0 || category != null;
    }

    public static boolean isTicketIsValid(UserEntity userEntity, int pageSize, int pageNum) {
        return isUserValid(userEntity) || isPageValid(pageSize, pageNum);
    }

    public static boolean isTicketIsValid(EventEntity eventEntity, int pageSize, int pageNum) {
        return isEventIsValid(eventEntity) || isPageValid(pageSize, pageNum);
    }

    public static boolean isTicketIdIsValid(long ticketId) {
        return ticketId >= 0;
    }
}
