package com.example.MyApp.demo.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/v1/books")
    public String getBooks(){
        return "I am just returning books";
    }

    //We can use requestMApping instead of GEt ot Post mapping , request mapping can be used for any http verbs


    //Spring Search for @component for creating objects (pojo classes), for this controller internal it inherits @component



    @GetMapping("/v2/books")
    public List<Book> getBooks1(){
       return bookRepository.findAll();

    }
/*
    @RequestMapping(value="/v2/books", method = RequestMethod.POST)
    public void insertBook(@RequestBody Book book){
        return bookRepository.

    }

    @GetMapping("/v2/book")
    public Book getBooksByID(@RequestParam(value = "id") int id){

    }

    @GetMapping("/v2/book")
    public Book getBooksByID(@PathVariable int id){

    }

 */

    @GetMapping("/booksByAuthor")
    public List<Book> getBooksbyAuthorName(@RequestParam(value = "name") String name){
        return bookRepository.getBooksByAuthor(name);

    }
}
