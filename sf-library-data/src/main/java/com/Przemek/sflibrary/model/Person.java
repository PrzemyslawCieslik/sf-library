package com.Przemek.sflibrary.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity {
    private String firstName;
    private String lastName;
    private LocalDate BirthDay;

    public Person(Long id, String firstName, String lastName, LocalDate birthDay) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        BirthDay = birthDay;
    }
}
