package com.Przemek.sflibrary.services;

import com.Przemek.sflibrary.model.User;

import java.util.List;

public interface UserService extends CrudService<User, Long> {

    User findByLastName(String lastName);

    User findByDocumentNumber(String documentNumber);

    List<User> findAllByLastName(String lastName);



}
