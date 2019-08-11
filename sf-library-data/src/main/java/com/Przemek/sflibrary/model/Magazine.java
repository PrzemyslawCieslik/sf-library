package com.Przemek.sflibrary.model;

import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Magazine extends Publication {
    private String language;

    @Builder
    public Magazine(Long id, int year, String title, String publisher, LocalDate releaseDate, String language) {
        super(id, year, title, publisher, releaseDate);
        this.language = language;
    }
}
