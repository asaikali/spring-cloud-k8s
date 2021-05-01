package com.example.messageservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivenessController {

  @GetMapping("/alive")
  public String alive()
  {
    return "ok";
  }
}
