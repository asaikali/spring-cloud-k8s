package com.example.messageservice;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ExampleHealthIndicator implements HealthIndicator
{
    private boolean state = true;

    @Override
    public Health health() {
        System.out.println("ExampleHealthIndicator called at " + LocalDateTime.now() + " state=" + state);
        if(state) {
            return Health.up().build();
        } else {
            return Health.down().build();
        }
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public boolean getState() {
        return state;
    }
}