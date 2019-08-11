package com.Przemek.sflibrary.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    public boolean isAlive(){
        if (isAlive() == false){
            return deathDate.isAfter(getBirthDay());
        }else
            return Boolean.valueOf("Living to today");
    }

    public Author(Long id,String firstName, String lastName, LocalDate BirthDay, String description, LocalDate deathDate) {
        super(id,firstName, lastName, BirthDay);
        this.description = description;
        this.deathDate = deathDate;
    }
}
