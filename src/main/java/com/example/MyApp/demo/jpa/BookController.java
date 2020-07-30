package com.example.MyApp.demo.jpa;

import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    PersonRepository personRepository;

    /*
    @GetMapping("/v1/books")
    public String getBooks(){
        return "I am just returning books";
    }
     */

    //We can use requestMApping instead of GEt ot Post mapping , request mapping can be used for any http verbs

    //Spring Search for @component for creating objects (pojo classes), for this controller internal it inherits @component

    @GetMapping("/v2/books")
    public List<Book> getBooks1(){
       return bookRepository.findAll();
    }

    @RequestMapping(value="/books", method = RequestMethod.POST)
    public void insertBook(@RequestBody Book book){
           bookRepository.save(book);
    }

    @GetMapping("/bookbyId")
    public Book getBooksByID(@RequestParam(value = "id") int id){
      Optional<Book> result= bookRepository.findById(id);
      return (Book)result.get();
    }

    @GetMapping("/bookbyId/{id}")
    public Book getBooksByPathParam(@PathVariable int id){
        Optional<Book> result= bookRepository.findById(id);
        return (Book)result.get();
    }

    @PostMapping("person")
        public void insertPerson(@RequestBody Person p){
        personRepository.save(p);
    }

    @GetMapping("/booksByAuthor")
    public List<Book> getBooksbyAuthorName(@RequestParam(value = "name") String name){
        return bookRepository.findByAuthorName(name);
    }

    @GetMapping("/booksByCost")
    public List<Book> getBooksbyCost(@RequestParam(value = "cost") int cost){
        return bookRepository.findByCost(cost);

    }

    @GetMapping("/booksByCosts")
    public List<Book> getBooksbyCosts(@RequestParam(value = "cost") int cost){
        return bookRepository.findByCosts(cost);

    }

    @GetMapping("/booksByprice")
    public List<Book> getBooksbyprice(@RequestParam(value = "cost") int cost) {
        List<Book> result = bookRepository.findByPrice(cost);

        if (result != null || result.size() == 0) {
            throw new InternalError();
        }
        return result;
    }

    @GetMapping("/booksByAuthorJpql")
    public List<Book> getBooksbyAuthorNameJPQL(@RequestParam(value = "name") String name){
        return bookRepository.getAuthorNameJPQL(name);
    }

    @GetMapping("/booksByAuthorSql")
    public List<Book> getBooksbyAuthorNameSql(@RequestParam(value = "name") String name){
        return bookRepository.getAuthorNameSQL(name);
    }

}
