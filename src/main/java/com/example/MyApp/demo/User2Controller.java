package com.example.MyApp.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class User2Controller {

    @Autowired
    User my_user;

    @GetMapping("/v7/user")
    public User getUserV9(){
        my_user.setAge(25);
        my_user.setName("ABC");
        System.out.println(my_user);
        return my_user;
    }
}
