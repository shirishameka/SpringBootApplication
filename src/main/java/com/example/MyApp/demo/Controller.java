package com.example.MyApp.demo;


import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.PathParam;
import java.util.Collections;
import java.util.List;

@RestController
public class Controller {

    Db db=new Db();

    @RequestMapping(value = "/hi2", method = RequestMethod.GET)
    public String sayHello2() {
        return "Hello Coders";
    }

    @GetMapping("/hi")//getmapping = requestmapping+get
    public String sayHello() {
        return "Hello Coders";
    }

    @ApiOperation("This api is for converting usd to inr")
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

    //Response Headers and change status code to 201
    @GetMapping("/v2/users")
    public ResponseEntity<User> getUser(){
        MultiValueMap<String, String> headers= new LinkedMultiValueMap<>();
        headers.put("Srever", Collections.singletonList("Shirisha"));
        headers.put("ClientName", Collections.singletonList("SampleResponsename"));
        User responseBody=new User(301,"siri2",25);
        ResponseEntity<User> response= new ResponseEntity<>(responseBody,headers, HttpStatus.ACCEPTED);
        return response;
    }


    //Suppose we are calling anothor API , suppose uber api calls paytm for payment
    @RequestMapping("/gitHub/users/{login}")
    public ResponseEntity<GitHubUser> get(@PathVariable("login") String login){
        RestTemplate restTemplate = new RestTemplate();
        //https://api.github.com/users/+login
        ResponseEntity<GitHubUser> response =
                restTemplate.getForEntity(String.format("https://api.github.com/users/%s",login),GitHubUser.class);
        System.out.println(response.getHeaders());
        System.out.println(response.getStatusCode());
        return response;
    }



}