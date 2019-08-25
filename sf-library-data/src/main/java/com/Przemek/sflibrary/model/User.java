package com.Przemek.sflibrary.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends Person {
    @Builder
    public User(Long id, String firstName, String lastName, LocalDate birthDay, String typeOfDocument, String documentNumber) {
        super(id, firstName, lastName, birthDay);
        this.typeOfDocument = typeOfDocument;
        this.documentNumber = documentNumber;
    }

    @Column(name = "type_of_document")
    @NotBlank
    private String typeOfDocument;

    @Column(name = "document_number")
    @NotBlank
    @Size(min = 5)
    private String documentNumber;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Book> books;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Magazine> magazines;

}
