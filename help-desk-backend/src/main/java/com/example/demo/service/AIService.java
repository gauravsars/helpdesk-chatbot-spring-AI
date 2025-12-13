package com.example.demo.service;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.TicketDatabaseTool;

//has capability to interact with AI , or It is the bridge between our app methods and GPT.
@Service
@RequiredArgsConstructor
public class AIService {

    private final ChatClient chatClient;

    private final TicketDatabaseTool ticketDatabaseTool;

    public String getResponseFromAssistant(String query) {
        return this.chatClient
                   .prompt()
                   .tools(ticketDatabaseTool)
                   .user(query)
                   .call()
                   .content();
    }

}
