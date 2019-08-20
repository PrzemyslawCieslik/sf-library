package com.Przemek.sflibrary.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity {

    @Column(name = "first_name")
    @NotBlank
    @Size(min = 3)
    private String firstName;

    @Column(name = "last_name")
    @NotBlank
    @Size(min = 3)
    private String lastName;

    @Column(name = "birth_day")
    @NotBlank
    private LocalDate BirthDay;

    public Person(Long id, String firstName, String lastName, LocalDate birthDay) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        BirthDay = birthDay;
    }
}
