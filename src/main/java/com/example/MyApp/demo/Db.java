package com.example.MyApp.demo;

import java.util.ArrayList;
import java.util.List;

public class Db {

    private ArrayList<User> userTable= new ArrayList<>();

    //Inserting dummy data into the list
    public Db()
    {
        userTable.add(new User(101,"Rami",202));
        userTable.add(new User(102,"Ashu",203));
    }

    public boolean addUser(User user){
        userTable.add(user);
        return true;
    }

    public List<User> getAllUsers(){
        return userTable;
    }
    public User findUser(int id){
        for(User user:userTable){
            if(user.getId()==id) return user;
        }
        System.out.println("Could not find the user");
        return null;
    }

    public boolean updateUser(User inputUser) {
        for(User user:userTable){
            if(user.getId()==inputUser.getId()){
                user.setAge(inputUser.getAge());
                user.setName(inputUser.getName());
                return true;
            }
        }
      return false;
    }

    public boolean deleteAUser(int id) {
        for(User user:userTable){
            if(user.getId()==id){
                 userTable.remove(user);
                 return true;
            }
        }
        return false;
    }
}
