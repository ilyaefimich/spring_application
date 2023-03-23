package com.epam.spring.service;

import com.epam.spring.dao.impl.DefaultEventDao;
import com.epam.spring.domain.entity.EventEntity;
import com.epam.spring.utils.ItemsFromPages;
import com.epam.spring.utils.Validation;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventService {

    private static final Logger LOG = Logger.getLogger(EventService.class.getName());
    DefaultEventDao eventDAO;
    private long eventId = 0;

    public EventService() {
    }

    public EventService(DefaultEventDao eventDAO) {
        this.eventDAO = eventDAO;
    }

    public void setEventDAO(DefaultEventDao eventDAO) {
        this.eventDAO = eventDAO;
    }

    public List<EventEntity> getEventsByTitle(String title, int pageSize, int pageNum) {
        if (!Validation.isEventParametersIsValid(title, pageSize, pageNum)) {
            LOG.log(Level.WARNING, String.format("Event with parameters %s, %d, %d is not valid", title, pageSize,
                    pageNum));
            throw new IllegalArgumentException();
        }
        LOG.log(Level.INFO, "Get events by title:" + title);
        return ItemsFromPages.getItemsFromPages(eventDAO.getEventsByTitle(title), pageSize, pageNum);
    }

    public List<EventEntity> getEventsForDay(Date day, int pageSize, int pageNum) {
        if (!Validation.isEventParametersIsValid(day, pageSize, pageNum)) {
            LOG.log(Level.WARNING, String.format("Event with parameters %s, %d, %d is not valid", day, pageSize,
                    pageNum));
            throw new IllegalArgumentException();
        }
        LOG.log(Level.INFO, "Get events by day:" + day);
        return ItemsFromPages.getItemsFromPages(eventDAO.getEventsForDay(day), pageSize, pageNum);
    }

    public EventEntity createEvent(EventEntity eventEntity) {
        if (!Validation.isEventIsValid(eventEntity)) {
            LOG.log(Level.WARNING, String.format("Event is not valid"));
            throw new IllegalArgumentException();
        }
        eventEntity.setId(eventId);
        eventDAO.createEvent(eventEntity);
        LOG.log(Level.INFO, "Created event: " + eventEntity);
        return eventEntity;
    }

    public EventEntity updateEvent(EventEntity eventEntity) {
        if (!Validation.isEventIsValid(eventEntity)) {
            LOG.log(Level.WARNING, String.format("Event with  is not valid"));
            throw new IllegalArgumentException();
        }
        LOG.log(Level.INFO, "Updated event:" + eventEntity);
        return eventDAO.updateEvent(eventEntity);
    }

    public boolean deleteEvent(long eventId) {
        if (!Validation.isEventIdIsValid(eventId)) {
            LOG.log(Level.WARNING, String.format("EventId is not valid"));
            throw new IllegalArgumentException();
        }
        LOG.log(Level.INFO, "Deleted event with id:" + eventId);
        return eventDAO.deleteEvent(eventId);
    }

    public EventEntity getEventById(long eventId) {
        if (!Validation.isEventIdIsValid(eventId)) {
            LOG.log(Level.WARNING, String.format("EventId is not valid"));
            throw new IllegalArgumentException();
        }
        LOG.log(Level.INFO, "Get event with id :" + eventId);
        return eventDAO.getEventById(eventId);
    }
}
