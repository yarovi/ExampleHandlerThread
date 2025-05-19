package org.yasmani.io.mybook.service;

import org.springframework.stereotype.Service;
import org.yasmani.io.mybook.entity.Book;
import org.yasmani.io.mybook.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
