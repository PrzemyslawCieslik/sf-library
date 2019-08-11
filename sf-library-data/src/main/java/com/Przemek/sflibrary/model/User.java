package com.Przemek.sflibrary.model;

import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends Person {
    private String typeOfDocument;
    private String documentNumber;

    @Builder
    public User(Long id, String firstName, String lastName, LocalDate birthDay, String typeOfDocument, String documentNumber) {
        super(id, firstName, lastName, birthDay);
        this.typeOfDocument = typeOfDocument;
        this.documentNumber = documentNumber;
    }
}
