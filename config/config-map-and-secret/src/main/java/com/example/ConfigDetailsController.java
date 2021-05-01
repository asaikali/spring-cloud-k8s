package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class ConfigDetailsController {

    private String messego;


    public ConfigDetailsController(@Value("${message:hardcoded default value}") String messego) {
        this.messego = messego;
    }

    @GetMapping("/")
    public Map<String,Object> get() {
        return Map.of("date", LocalDateTime.now(),
                "message", messego);
    }

}
