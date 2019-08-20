package com.Przemek.sflibrary.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book extends Publication {

    @Builder
    public Book(Long id, String title, String publisher, LocalDate releaseDate, String isbn, int pages) {
        super(id, title, publisher, releaseDate);
        this.isbn = isbn;
        this.pages = pages;
    }

    @Column(name = "isbn")
    @NotBlank
    @Size(min = 10, max = 13)
    private String isbn;

    @NotBlank
    @Column(name = "pages")
    private int pages;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

}
