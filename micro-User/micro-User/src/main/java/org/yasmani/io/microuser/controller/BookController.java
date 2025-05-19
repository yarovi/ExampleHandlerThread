package org.yasmani.io.microuser.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yasmani.io.microuser.entity.Book;
import org.yasmani.io.microuser.service.BookService;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/books")
public class BookController {

    Logger logger = Logger.getLogger("BookController");

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    // Add methods to handle HTTP requests (e.g., GET, POST, PUT, DELETE) here

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() throws InterruptedException {
        logger.info("Fetching all books");
        Thread.sleep(5000);
        return ResponseEntity.ok(bookService.findAll());
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) throws InterruptedException {
        logger.info("Creating a new book: " + book);
        Thread.sleep(5000);

        Book savedBook = bookService.save(book);
        return ResponseEntity.status(201).body(savedBook);
    }
}
