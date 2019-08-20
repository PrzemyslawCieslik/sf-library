package com.Przemek.sflibrary.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Publication extends BaseEntity {

    public Publication(Long id, String title, String publisher, LocalDate releaseDate) {
        super(id);
        this.title = title;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
    }

    @Column(name = "title")
    private String title;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "release_date")
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private LocalDate releaseDate;

}
