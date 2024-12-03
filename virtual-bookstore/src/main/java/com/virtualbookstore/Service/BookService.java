package com.virtualbookstore.Service;

import com.virtualbookstore.Entity.Book;
import com.virtualbookstore.Repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book){
        if(book == null) {
            throw new RuntimeException("Invalid Book");
        }else {
            return bookRepository.save(book);
        }
    }

    public Book getBook(Long id){

            return bookRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Book not found"));

    }

    public void updateBook(Long id, Book update){
        if(update == null || id == null){
            throw new RuntimeException("Invalid Book");
        }

        if(bookRepository.existsById(id)){
            Book book = bookRepository.getReferenceById(id);
            book.setTitle(update.getTitle());
            book.setAuthor(update.getAuthor());
            book.setPrice(update.getPrice());
            book.setPublisher(update.getPublisher());

            log.info("Book Updated by id: "+id);
        }else {
            throw  new RuntimeException("Book not Found");
        }
    }

    public void deleteBook(Long id){
        if(bookRepository.existsById(id)){
            bookRepository.deleteById(id);
            log.info("Book deleted by id:",id);
        }else {
            throw new RuntimeException("Book not Found");
        }

    }
}
