package com.example.demo.service;

import com.example.demo.entity.Ticket;
import com.example.demo.repository.TicketRepository;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    //create ticket
    @Transactional
    public Ticket createTicket(Ticket ticket) {
        ticket.setId(null);
        return ticketRepository.save(ticket);
    }

    public Ticket getTicket(Long ticketId) {
        return ticketRepository.findById(ticketId).orElse(null);
    }


    public Ticket updateTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }


    //get ticket by username
    public Ticket getTicketByEmailId(String email) {
        return ticketRepository.findByEmail(email).orElse(null);
    }


}
