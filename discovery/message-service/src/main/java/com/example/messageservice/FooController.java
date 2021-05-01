package com.example.messageservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class FooController {

  @Value("${foo}")
  private String fooValue;

  @GetMapping("/foo")
  public String foo()
  {
    return fooValue;
  }
}
