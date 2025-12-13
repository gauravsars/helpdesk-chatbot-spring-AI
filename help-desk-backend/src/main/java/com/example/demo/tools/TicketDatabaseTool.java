package com.example.demo.tools;


import com.example.demo.entity.Ticket;
import com.example.demo.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class TicketDatabaseTool {

    private final TicketService ticketService;

    @Tool(description = "This tool helps to create new ticket in database.")
    public Ticket createTicketTool(@ToolParam(description = "Ticket fields  required to create new ticket.")Ticket ticket) {
        try {
            System.out.println("going to create ticket");
            System.out.println(ticket);
            return ticketService.createTicket(ticket);
        }
        catch(Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    @Tool(description = "This tool helps to get ticket by emailId.")
    public Ticket getTicketByUserName(@ToolParam(description = "emailId whose ticket is required.")String emailid) {
        return ticketService.getTicketByEmailId(emailid);
    }

    @Tool(description = "This tool helps to update the ticket")
    public Ticket updateTicket(@ToolParam(description = "new ticket details with ticket id.") Ticket ticket) {
         Ticket dbTicketObject = getTicketByUserName(ticket.getEmail());

         if (Objects.nonNull(ticket.getPriority())) {
             dbTicketObject.setPriority(ticket.getPriority());
         }
         if (Objects.nonNull(ticket.getStatus())) {
            dbTicketObject.setStatus(ticket.getStatus());
         }
         if (Objects.nonNull(ticket.getSummary())) {
            dbTicketObject.setSummary(ticket.getSummary());
         }

        return ticketService.updateTicket(dbTicketObject);
    }



}
