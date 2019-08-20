package com.Przemek.sflibrary.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author extends Person {

    @Builder
    public Author(Long id,String firstName, String lastName, LocalDate BirthDay, String description, LocalDate deathDate) {
        super(id, firstName, lastName, BirthDay);
        this.description = description;
        this.deathDate = deathDate;
    }

    @Column(name = "description")
    @NotBlank
    @Size(max = 500)
    private String description;

    @Column(name = "death_date")
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private LocalDate deathDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private Set<Book> books = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private Set<Magazine> magazines = new HashSet<>();


}
