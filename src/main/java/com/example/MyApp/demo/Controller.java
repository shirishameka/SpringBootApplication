package com.example.MyApp.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/hi")
    public String sayHello() {
        return "Hello Coders";
    }

    @GetMapping("/usd_to_inr")
    public int convertToINR(@RequestParam int q) {
        int usd = q;
        return 75 * usd;
    }

    @GetMapping("/user")
    public User getAUser(){
        User user= new User(1,"Siri",25);
        return user;
    }
}