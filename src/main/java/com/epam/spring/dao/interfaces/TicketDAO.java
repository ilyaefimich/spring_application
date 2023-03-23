package com.epam.spring.dao.interfaces;

import com.epam.spring.domain.entity.EventEntity;
import com.epam.spring.domain.entity.TicketEntity;
import com.epam.spring.domain.entity.UserEntity;

import java.util.List;

public interface TicketDAO {

    TicketEntity createTicket(TicketEntity ticket);

    List<TicketEntity> getBookedTickets(UserEntity user);

    List<TicketEntity> getBookedTickets(EventEntity event);

    boolean cancelTicket(long ticketId);

}
