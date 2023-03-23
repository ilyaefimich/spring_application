package com.epam.spring.dao.impl;

import com.epam.spring.dao.interfaces.TicketDAO;
import com.epam.spring.domain.entity.EventEntity;
import com.epam.spring.domain.entity.TicketEntity;
import com.epam.spring.domain.entity.UserEntity;
import com.epam.spring.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.epam.spring.namespace.Constants.TICKET;

public class DefaultTicketDao implements TicketDAO {

    @Autowired
    Repository repository;
    Random ran = new Random();
    private int ticketId = ran.nextInt(6) + 5;

    @Override
    public TicketEntity createTicket(TicketEntity ticket) {
        ticket.setId(ticketId);
        repository.put(TICKET + ticket.getId(), ticket);
        TicketEntity tempTicket = (TicketEntity) repository.getRepository().get(TICKET + ticket.getId());
        return tempTicket;
    }

    @Override
    public List<TicketEntity> getBookedTickets(UserEntity user) {
        List<TicketEntity> ticketList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : repository.getRepository().entrySet()) {
            if (entry.getKey().startsWith(TICKET)) {
                TicketEntity ticket = (TicketEntity) entry.getValue();
                if (user.getId() == ticket.getUserId()) {
                    ticketList.add(ticket);
                }
            }
        }
        return ticketList;
    }

    @Override
    public List<TicketEntity> getBookedTickets(EventEntity event) {
        List<TicketEntity> ticketList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : repository.getRepository().entrySet()) {
            if (entry.getKey().startsWith(TICKET)) {
                TicketEntity ticket = (TicketEntity) entry.getValue();
                if (event.getId() == ticket.getEventId()) {
                    ticketList.add(ticket);
                }
            }
        }
        return ticketList;
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        if (repository.getRepository().containsKey(TICKET + ticketId)) {
            repository.delete(TICKET + ticketId);
            return true;
        }
        return false;
    }
}
