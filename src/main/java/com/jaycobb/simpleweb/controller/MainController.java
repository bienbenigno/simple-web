package com.jaycobb.simpleweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MainController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping
    public Map<String, String> index() {

        final Map<String, String> message = new HashMap<>();
        message.put("message", "Hello, " + counter.incrementAndGet());
        return message;
    }
}
