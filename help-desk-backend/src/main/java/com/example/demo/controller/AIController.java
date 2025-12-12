package com.example.demo.controller;

import com.example.demo.service.AIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ai")
@RequiredArgsConstructor
public class AIController {

    private final AIService service;

    @PostMapping
    public ResponseEntity<String> getResponse(@RequestBody String query) {
        System.out.println("GROQ KEY = " + System.getenv("GROQ_API_KEY"));
        return ResponseEntity.ok(service.getResponseFromAssistant(query));
    }
}
