package org.yasmani.io.mybook.entity;

import jakarta.persistence.*;
import lombok.Data;
@Data

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String author;
    private int year;
}
