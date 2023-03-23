package com.epam.spring.utils;

import com.epam.spring.domain.entity.EventEntity;
import com.epam.spring.domain.entity.UserEntity;
import com.epam.spring.repository.Repository;
import com.epam.spring.service.BookingService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.epam.spring.namespace.Constants.EVENT;
import static com.epam.spring.namespace.Constants.USER;

public class InitializationTest {

    public final ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/resources/spring" +
            "-config.xml");
    protected final BookingService bookingService = (BookingService) context.getBean("bookingService");
    protected final Repository repository = (Repository) context.getBean("repository");

    protected List<EventEntity> events = new ArrayList<>();
    protected List<UserEntity> users = new ArrayList<>();

    protected void initListOfEvents() {
        for (Map.Entry<String, Object> entry : repository.getRepository().entrySet()) {
            if (entry.getKey().startsWith(EVENT)) {
                events.add((EventEntity) entry.getValue());
            }
        }

        Collections.sort(events, UtilsComparator.eventsComparator);
    }

    protected void initEventFacade() {
        for (EventEntity event : events) {
            bookingService.createEvent(event);
        }

        Collections.sort(events, UtilsComparator.eventsComparator);

    }

    protected void initListOfUsers() {
        for (Map.Entry<String, Object> entry : repository.getRepository().entrySet()) {
            if (entry.getKey().startsWith(USER)) {
                users.add((UserEntity) entry.getValue());
            }
        }

        Collections.sort(users, UtilsComparator.usersComparator);
    }

    protected void initUsersFacade() {
        for (UserEntity user : users) {
            bookingService.createUser(user);
        }

        Collections.sort(users, UtilsComparator.usersComparator);
    }

}
