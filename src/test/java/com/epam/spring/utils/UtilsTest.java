package com.epam.spring.utils;

import com.epam.spring.domain.entity.EventEntity;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class UtilsTest {

    private EventEntity event1, event2, event3, event4, event5, event6, event7,eventUUH, sdcsdc, bsdcsbdc, dsfjj, event11;
    List<EventEntity> eventList;

    @Before
    public void initList(){
        eventList = Arrays.asList(event1, event2, event3, event4, event5, event6, event7, eventUUH, sdcsdc, bsdcsbdc, dsfjj, event11);
    }

    @Test
    public void testShouldGetItemsFromPages(){
        ItemsFromPages.getItemsFromPages(eventList, 5, 3);

    }

}