package com.epam.spring.dao.impl;

import com.epam.spring.dao.interfaces.EventDAO;
import com.epam.spring.domain.entity.EventEntity;
import com.epam.spring.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import static com.epam.spring.namespace.Constants.EVENT;

public class DefaultEventDao implements EventDAO {

    @Autowired
    Repository repository;

    @Override
    public EventEntity getEventById(long eventId) {
        EventEntity tempEvent = null;
        for (Map.Entry<String, Object> entry : repository.getRepository().entrySet()) {
            if (entry.getKey().contains(EVENT + eventId)) {
                tempEvent = (EventEntity) entry.getValue();
                break;
            }
        }
        return tempEvent;
    }

    @Override
    public List<EventEntity> getEventsByTitle(String title) {
        List<EventEntity> events = new ArrayList<>();
        for (Map.Entry<String, Object> entry : repository.getRepository().entrySet()) {
            if (entry.getValue().toString().contains(title)) {
                events.add((EventEntity) entry.getValue());
            }
        }
        return events;
    }

    @Override
    public List<EventEntity> getEventsForDay(Date day) {
        List<EventEntity> events = new ArrayList<>();
        for (Map.Entry<String, Object> entry : repository.getRepository().entrySet()) {
            EventEntity event = (EventEntity) entry.getValue();
            if (event.getDate().equals(day)) {
                events.add(event);
            }
        }
        return events;
    }

    @Override
    public void createEvent(EventEntity eventEntity) {
        repository.put(EVENT + eventEntity.getId(), eventEntity);
    }

    @Override
    public EventEntity updateEvent(EventEntity eventEntity) {
        EventEntity tempEvent = null;
        if (repository.getRepository().containsKey(EVENT + eventEntity.getId())) {
            tempEvent = (EventEntity) repository.get(EVENT + eventEntity.getId());

            tempEvent.setDate(eventEntity.getDate());

            tempEvent.setTitle(eventEntity.getTitle());
            repository.put(EVENT + eventEntity.getId(), tempEvent);
        }
        return tempEvent;
    }

    @Override
    public boolean deleteEvent(long eventId) {
        if (repository.getRepository().containsKey(EVENT + Long.toString(eventId))) {
            repository.delete(EVENT + Long.toString(eventId));
            return true;
        }
        return false;
    }
}
