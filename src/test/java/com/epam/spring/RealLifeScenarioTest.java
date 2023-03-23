package com.epam.spring;

import com.epam.spring.domain.entity.EventEntity;
import com.epam.spring.domain.entity.TicketEntity;
import com.epam.spring.domain.entity.UserEntity;
import com.epam.spring.utils.InitializationTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

public class RealLifeScenarioTest extends InitializationTest {

    private ArrayList<EventEntity> eventList = new ArrayList<>();
    private ArrayList<UserEntity> userList = new ArrayList<>();

    @Test
    public void testSomeRealScenario() {

        UserEntity testUser = new UserEntity("updatedUser", "updatedUser@epam.com");
        userList.add(testUser);

        UserEntity testUser1 = new UserEntity("maksym_mazurkevych", "Maksym_Mazurkevych@epam.com");
        userList.add(testUser1);

        for (UserEntity eve : userList) {
            bookingService.createUser(eve);
        }

        EventEntity event = new EventEntity("RealEventScenario", new Date());
        eventList.add(event);

        EventEntity event1 = new EventEntity("Vakarchuk", new Date());
        eventList.add(event1);

        for (EventEntity eve : eventList) {
            bookingService.createEvent((EventEntity) eve);
        }

        bookingService.bookTicket(testUser.getId(), event.getId(), 10, TicketEntity.Category.BAR);
        bookingService.bookTicket(testUser1.getId(), event.getId(), 11, TicketEntity.Category.BAR);

        bookingService.bookTicket(testUser.getId(), event1.getId(), 111, TicketEntity.Category.PREMIUM);
        bookingService.bookTicket(testUser1.getId(), event1.getId(), 112, TicketEntity.Category.PREMIUM);

        Assert.assertEquals(bookingService.getBookedTickets(testUser, 5, 1).size(), 4);
        Assert.assertEquals(bookingService.getBookedTickets(testUser1, 5, 1).size(), 4);

        bookingService.cancelTicket(3);

        Assert.assertEquals(bookingService.getBookedTickets(testUser1, 5, 1).size(), 3);

    }

}
