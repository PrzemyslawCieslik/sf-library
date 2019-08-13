package com.Przemek.sflibrary.model;

import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author extends Person {

    private String description;
    private LocalDate deathDate;


    @Builder
    public Author(Long id,String firstName, String lastName, LocalDate BirthDay, String description, LocalDate deathDate) {
        super(id,firstName, lastName, BirthDay);
        this.description = description;
        this.deathDate = deathDate;
    }
}
