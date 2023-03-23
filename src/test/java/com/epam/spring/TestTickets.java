package com.epam.spring;

import com.epam.spring.domain.entity.TicketEntity;
import com.epam.spring.utils.InitializationTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestTickets extends InitializationTest {

    List<TicketEntity> ticketList = new ArrayList<>();

    @Before
    public void init() {
        initListOfEvents();
        initEventFacade();
        initListOfUsers();
        initUsersFacade();
        initListOfTickets();
        bookTicketsFacade();
    }

    private void initListOfTickets() {
        ticketList.add(new TicketEntity(0, 0, 1, 1, TicketEntity.Category.STANDARD));
        ticketList.add(new TicketEntity(1, 0, 0, 10, TicketEntity.Category.PREMIUM));
        ticketList.add(new TicketEntity(2, 1, 1, 13, TicketEntity.Category.BAR));
        ticketList.add(new TicketEntity(3, 1, 0, 18, TicketEntity.Category.BAR));
    }

    private void bookTicketsFacade() {
        bookingService.bookTicket(0, 1, 1, TicketEntity.Category.STANDARD);
        bookingService.bookTicket(0, 0, 10, TicketEntity.Category.PREMIUM);
        bookingService.bookTicket(1, 1, 13, TicketEntity.Category.BAR);
        bookingService.bookTicket(1, 0, 18, TicketEntity.Category.BAR);
    }

    @Test
    public void testCreateTicket() {
        List<TicketEntity> list1 = bookingService.getBookedTickets(users.get(0), 10, 1);
        Assert.assertTrue(ticketList.containsAll(list1));
    }

    @Test
    public void testCancelTicket() {
        int tempSize = repository.getRepository().size();
        bookingService.cancelTicket(1);
        int currentRepositorySize = repository.getRepository().size();

        Assert.assertEquals(tempSize - 1, currentRepositorySize);
    }

    @Test
    public void testGetBookedTicketsByEvents() {
        List<TicketEntity> facadeList = bookingService.getBookedTickets(events.get(1), 5, 1);
        Assert.assertTrue(ticketList.containsAll(facadeList));
    }
}
