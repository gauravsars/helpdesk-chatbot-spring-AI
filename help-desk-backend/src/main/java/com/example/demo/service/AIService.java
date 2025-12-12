package com.example.demo.service;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//has capability to interact with AI , or It is the bridge between our app methods and GPT.
@Service
@RequiredArgsConstructor
public class AIService {

    private final ChatClient chatClient;

    public String getResponseFromAssistant(String query) {
        return this.
                    chatClient.
                            prompt().
                                user(query).
                                    call().
                                        content();
    }

}
