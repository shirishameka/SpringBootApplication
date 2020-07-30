package com.example.MyApp.demo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
/*
    @Query("select * from books where books.authorName:name" )
    public List<Book> getBooksByAuthor(String name);

    @Query("Here you can write a query and override it ")
    @Override
    List<Book> findAll();

 */

    public List<Book> findByAuthorName(String name);

    public List<Book> findByCost(int cost);

    //JPQL -Java  persistence query language
    @Query("select b from Book b where b.cost=:cost")
    public List<Book> findByCosts(int cost);


    //Native SQL
    @Query(value= "select * from Book b where b.cost=:cost", nativeQuery = true )
    public List<Book> findByPrice(int cost);

    //JPQL
    @Query("select b from Book b where b.authorName=:name")
    public List<Book> getAuthorNameJPQL(String name);

    //SQL
    @Query(value= "select * from Book b where b.author_name=:name", nativeQuery = true )
    public List<Book> getAuthorNameSQL(String name);

    /*
    @Query(value= "select * from Book b,Author a  where b.auhorId=:a.id", nativeQuery = true )
    public List<Book> getjoin(String name);

     */
}
