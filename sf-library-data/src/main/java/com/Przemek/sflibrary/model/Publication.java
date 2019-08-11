package com.Przemek.sflibrary.model;

import lombok.*;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Publication extends BaseEntity {

    private int year;
    private String title;
    private String publisher;
    private LocalDate releaseDate;

    @Builder
    public Publication(Long id, int year, String title, String publisher, LocalDate releaseDate) {
        super(id);
        this.year = year;
        this.title = title;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
    }
}
