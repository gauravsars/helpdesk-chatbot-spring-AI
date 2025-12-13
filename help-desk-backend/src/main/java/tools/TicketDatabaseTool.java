package tools;


import com.example.demo.entity.Ticket;
import com.example.demo.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TicketDatabaseTool {

    private final TicketService ticketService;

    @Tool(description = "This tool helps to create new ticket in database.")
    public Ticket createTicketTool(@ToolParam(description = "Ticket Details")Ticket ticket) {
        return ticketService.createTicket(ticket);
    }

    @Tool(description = "This tool helps to get ticket by username.")
    public Ticket getTicketByUserName(@ToolParam(description = "username whose ticket is required.")String username) {
        return ticketService.getTicketByEmailId(username);
    }

    @Tool(description = "This tool helps to update the ticket")
    public Ticket updateTicket(@ToolParam(description = "new ticket details with ticket id.") Ticket ticket) {
        return ticketService.updateTicket(ticket);
    }

}
