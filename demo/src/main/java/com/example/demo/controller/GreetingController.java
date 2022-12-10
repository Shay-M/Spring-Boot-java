package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // component that contains routes
public class GreetingController {

    @RequestMapping("/") // the default is get for post > ("/" , method = RequestMethod.post)
    public String getGreeting() {
        return "i love lings";
    }
}
