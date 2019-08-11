package com.Przemek.sflibrary.model;

import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book extends Publication {
    private String isbn;
    private int pages;

    @Builder
    public Book(Long id, int year, String title, String publisher, LocalDate releaseDate, String isbn, int pages) {
        super(id, year, title, publisher, releaseDate);
        this.isbn = isbn;
        this.pages = pages;
    }
}
