package com.example.MyApp.demo.jpa;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

public class Author {

    @Id
    private int id;
    private String name;

    @OneToMany
    private List<Book> books;
}
