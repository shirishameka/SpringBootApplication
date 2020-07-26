package com.example.MyApp.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Myconfig {


    //@bean spring knows that it has to create an object, so for that class we have to maek ,@Configuration/@Component
    //We can use @component at class level
    //For creating multiple objects  @Scope("prototype")
    //We can also Annotate @Service at User class
    @Bean
    @Scope("singleton")
    public User1 getuser(){
        return new User1("user1",20);
    }
}
