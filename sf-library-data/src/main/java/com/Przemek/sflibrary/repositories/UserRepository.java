package com.Przemek.sflibrary.repositories;

import com.Przemek.sflibrary.model.User;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByLastName(String lastName);

    User findByDocumentNumber(String documentNumber);

    List<User> findByBirthDate(LocalDate birthDate);
}
