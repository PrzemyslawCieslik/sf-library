package com.Przemek.sflibrary.services;

import com.Przemek.sflibrary.model.User;

import java.time.LocalDate;
import java.util.List;

public interface UserService extends CrudService<User, Long> {

    User findByLastName(String lastName);

    List<User> findAllByLastName(String lastName);

    User findByDocumentNumber(String documentNumber);

    List<User> findByBirthDate(LocalDate birthDate);



}
