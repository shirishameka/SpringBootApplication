package com.example.MyApp.demo;


import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class Controller {

    Db db=new Db();

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

    //Create New user -POST
    @PostMapping("/users")
    public boolean createUser(@RequestBody User user) {
    return db.addUser(user);
    }

    @GetMapping("/getAllUsers")
    public List<User> getALlUsers(){
        return db.getAllUsers();
    }

    //Search a user by user_id
    //localhost:8090/search/user?id=101 -query param
    @GetMapping("/search/user")
    public User findUser(@RequestParam int id){
    return db.findUser(id);
    }

    //Search a user by user_id
    //localhost:8090/search/user?id=101 -path param
    @GetMapping("/search/user/{id}")
    public User findAUserWithPathParam(@PathVariable int id){
        return db.findUser(id);
    }

    @PutMapping("/users")
    public boolean updateAUser(@RequestBody User user) {
     return  db.updateUser(user);
    }

    @DeleteMapping("/users/{id}")
    public boolean deleteAUser(@PathVariable int id){
    return db.deleteAUser(id);
    }


}