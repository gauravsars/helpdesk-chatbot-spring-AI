package com.example.demo.service;

import com.example.demo.tools.EmailTool;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import com.example.demo.tools.TicketDatabaseTool;


//has capability to interact with AI , or It is the bridge between our app methods and GPT.
@Service
@RequiredArgsConstructor
public class AIService {

    private final ChatClient chatClient;

    private final TicketDatabaseTool ticketDatabaseTool;

    private final EmailTool emailTool;

    @Value("classpath:/helpdesk-system.st")
    private Resource systemPromptResource;


    public String getResponseFromAssistant(String query) {
        return this.chatClient
                   .prompt()
                   .tools(ticketDatabaseTool,emailTool)
                   .system(systemPromptResource)
                   .user(query)
                   .call()
                   .content();
    }

}
