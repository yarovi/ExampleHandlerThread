package org.yasmani.io.mybook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yasmani.io.mybook.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
