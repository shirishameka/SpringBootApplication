package com.example.MyApp.demo;

import org.springframework.stereotype.Component;

@Component
public class User1 {

    private String name;

    public User1(){

    }

    public User1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
