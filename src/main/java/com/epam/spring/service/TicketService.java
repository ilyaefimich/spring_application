package com.epam.spring.service;

import com.epam.spring.dao.impl.DefaultTicketDao;
import com.epam.spring.domain.entity.EventEntity;
import com.epam.spring.domain.entity.TicketEntity;
import com.epam.spring.domain.entity.UserEntity;
import com.epam.spring.utils.ItemsFromPages;
import com.epam.spring.utils.Validation;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TicketService {

    private static final Logger LOG = Logger.getLogger(TicketService.class.getName());

    DefaultTicketDao ticketDao;

    public TicketService() {
    }

    public TicketService(DefaultTicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    public void setTicketDao(DefaultTicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    public TicketEntity bookTicket(long userId, long eventId, int place, TicketEntity.Category category) {
        if (!Validation.isTicketParametersIsValid(userId, eventId, place, category)) {
            LOG.log(Level.WARNING, String.format("Ticket parameters are not valid"));
            throw new IllegalArgumentException();
        }
        TicketEntity ticket = new TicketEntity.Builder().
                setUserId(userId).
                setEventId(eventId).
                setPlace(place).
                setCategory(category).build();
        LOG.log(Level.INFO, "Booked ticket:" + ticket);
        return (TicketEntity) ticketDao.createTicket(ticket);
    }

    public List<TicketEntity> getBookedTickets(UserEntity userEntity, int pageSize, int pageNum) {
        if (!Validation.isTicketIsValid(userEntity, pageSize, pageNum)) {
            LOG.log(Level.WARNING, String.format("ticket parameters are not valid"));
            throw new IllegalArgumentException();
        }
        LOG.log(Level.INFO, "Get booked tickets:" + userEntity);
        return ItemsFromPages.getItemsFromPages(ticketDao.getBookedTickets(userEntity), pageSize, pageNum);
    }

    public List<TicketEntity> getBookedTickets(EventEntity eventEntity, int pageSize, int pageNum) {
        if (!Validation.isTicketIsValid(eventEntity, pageSize, pageNum)) {
            LOG.log(Level.WARNING, String.format("ticket parameters are not valid"));
            throw new IllegalArgumentException();
        }
        LOG.log(Level.INFO, "Get booked tickets:" + eventEntity);
        return ItemsFromPages.getItemsFromPages(ticketDao.getBookedTickets(eventEntity), pageSize, pageNum);
    }

    public boolean cancelTicket(long ticketId) {
        if (!Validation.isTicketIdIsValid(ticketId)) {
            LOG.log(Level.WARNING, String.format("ticket parameters are not valid"));
            throw new IllegalArgumentException();
        }
        LOG.log(Level.INFO, "Canceled ticket:" + ticketId);
        return ticketDao.cancelTicket(ticketId);
    }
}
