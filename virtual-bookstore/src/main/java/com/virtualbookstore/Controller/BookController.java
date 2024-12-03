package com.virtualbookstore.Controller;

import com.virtualbookstore.Entity.Book;
import com.virtualbookstore.Service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@Slf4j
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id){

            Book book = bookService.getBook(id);
            return ResponseEntity.ok(book);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book addMovie = bookService.addBook(book);
        return ResponseEntity.ok(addMovie);
    }

    @PutMapping("/id")
    public ResponseEntity<String> updateBook(@PathVariable Long id, @RequestBody Book book){
        bookService.updateBook(id, book);
        return ResponseEntity.ok("Book updated with id: "+id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return ResponseEntity.ok("Book deleted with id: "+id);
    }
}
