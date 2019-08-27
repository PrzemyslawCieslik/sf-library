package com.Przemek.sflibrary.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "magazines")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Magazine extends Publication {

    @Builder
    public Magazine(Long id, String title, String publisher, LocalDate releaseDate, String language) {
        super(id,title, publisher, releaseDate);
        this.language = language;
    }

    @Column(name = "language")
    @NotBlank
    private String language;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToMany
    private Set<User> user;
}
