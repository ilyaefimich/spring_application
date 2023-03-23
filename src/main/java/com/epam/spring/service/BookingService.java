package com.epam.spring.service;

import com.epam.spring.domain.entity.EventEntity;
import com.epam.spring.domain.entity.TicketEntity;
import com.epam.spring.domain.entity.UserEntity;
import com.epam.spring.facade.BookingFacade;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class BookingService implements BookingFacade {

    private EventService eventService;
    private UserService userService;
    private TicketService ticketService;

    public BookingService(EventService eventService, UserService userService, TicketService ticketService) {
        this.eventService = eventService;
        this.userService = userService;
        this.ticketService = ticketService;
    }

    @Override
    public EventEntity getEventById(long eventId) {
        return (EventEntity) eventService.getEventById(eventId);
    }

    @Override
    public List<EventEntity> getEventsByTitle(String title, int pageSize, int pageNum) {
        return eventService.getEventsByTitle(title, pageSize, pageNum);
    }

    @Override
    public List<EventEntity> getEventsForDay(Date day, int pageSize, int pageNum) {
        return eventService.getEventsForDay(day, pageSize, pageNum);
    }

    @Override
    public EventEntity createEvent(EventEntity event) {
        return eventService.createEvent(event);
    }

    @Override
    public EventEntity updateEvent(EventEntity event) {
        return eventService.updateEvent(event);
    }

    @Override
    public boolean deleteEvent(long eventId) {
        return eventService.deleteEvent(eventId);
    }

    @Override
    public UserEntity getUserById(long userId) {
        return userService.getUserById(userId);
    }

    @Override
    public Optional<UserEntity> getUserByEmail(String email) {
        return userService.getUserByEmail(email);
    }

    @Override
    public List<UserEntity> getUsersByName(String name, int pageSize, int pageNum) {
        return userService.getUsersByName(name, pageSize, pageNum);
    }

    @Override
    public UserEntity createUser(UserEntity user) {
        return userService.createUser(user);
    }

    @Override
    public UserEntity updateUser(UserEntity user) {
        return userService.updateUser(user);
    }

    @Override
    public boolean deleteUser(long userId) {
        return userService.deleteUser(userId);
    }

    public TicketEntity bookTicket(long userId, long eventId, int place, TicketEntity.Category category) {
        return ticketService.bookTicket(userId, eventId, place, category);
    }

    @Override
    public List<TicketEntity> getBookedTickets(UserEntity user, int pageSize, int pageNum) {
        return ticketService.getBookedTickets(user, pageSize, pageNum);
    }

    @Override
    public List<TicketEntity> getBookedTickets(EventEntity event, int pageSize, int pageNum) {
        return ticketService.getBookedTickets(event, pageSize, pageNum);
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        return ticketService.cancelTicket(ticketId);
    }
}
