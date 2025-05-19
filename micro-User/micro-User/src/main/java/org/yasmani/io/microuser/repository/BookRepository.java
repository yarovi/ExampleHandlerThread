package org.yasmani.io.microuser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yasmani.io.microuser.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
