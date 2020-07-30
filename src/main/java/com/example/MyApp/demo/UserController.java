package com.example.MyApp.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    /*
    @Autowired
    User my_user;

     */

    @Autowired
    Myconfig myconfig;


    @Autowired
    UserService service;

    @GetMapping("/v6/user")
    public User1 getUserV6(){
       User1 my_user= myconfig.getuser();
        my_user.setAge(25);
        my_user.setName("ABC");
        System.out.println(my_user);
        return my_user;
        /*
        my_user.setAge(25);
        my_user.setName("ABC");
        System.out.println(my_user);
        return my_user;

         */
    }
/*

    @GetMapping("/v3/users")
    public String getUser(){
        return "My name is user";
    }

    //We can use requestMApping instead of GEt ot Post mapping , request mapping can be used for any http verbs
    @RequestMapping(value ="/v3/users",method = RequestMethod.POST)
    public void getUserPost(@RequestBody User1 user1){
        System.out.println(user1);
    }

 */

    //Diff between @Restcontroller and @Controller
    //@Rest controller (here we are passing java class , but response it is converting into json
    //Threfore , @Restcontroller will return json at all point

    @GetMapping("/v4/user")
    public User1 getUserV4(){
        return new User1("user1", 21);
    }

    //@controller: replace @Restcontroller .... gives 500, error is you have not defiend the view

    //controller will not convert java class to json , it will send as it is

    //with @controller , add @ResponseBody --- it will work

    //Therefore @Restcontroller -- will inherit both @Controller and @Responsebody

    /*
    Http protocol:
    soap and rest
     */

    //no need to creat a object for controller , spring will provide by default

/*

    //We can use requestMApping instead of GEt ot Post mapping , request mapping can be used for any http verbs
    @RequestMapping(value ="/v3/users",method = RequestMethod.POST)
    public void getUser1Post(@RequestBody List<User1> user1){
        System.out.println(user1);
        service.insert(user1);
    }

*/
}
