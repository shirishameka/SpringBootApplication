package com.example.MyApp.demo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {

    @Query("select * from books where books.authorName:name" )
    public List<Book> getBooksByAuthor(String name);

    @Query("Here you can write a query and override it ")
    @Override
    List<Book> findAll();
}
