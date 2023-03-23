package com.epam.spring;

import com.epam.spring.domain.entity.EventEntity;
import com.epam.spring.utils.InitializationTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class TestEvents extends InitializationTest {

    @Before
    public void init() {
        initListOfEvents();
        initEventFacade();
    }

    @Test
    public void testCreateEvent() {
        EventEntity event1 = events.get(0);
        EventEntity event2 = bookingService.getEventById(0);
        Assert.assertEquals(event1, event2);
    }

    @Test
    public void testUpdateEvent() {
        EventEntity eventExample = new EventEntity("updatedEventTitle", new Date(2017, 12, 13));
        eventExample.setId(1);
        bookingService.updateEvent(eventExample);
        Assert.assertEquals(eventExample.getTitle(), bookingService.getEventById(1).getTitle());
        Assert.assertEquals(eventExample.getDate(), bookingService.getEventById(1).getDate());
    }

    @Test
    public void testDeleteEvent() {
        bookingService.deleteEvent(1);
        Assert.assertEquals(null, bookingService.getEventById(1));
    }
}
