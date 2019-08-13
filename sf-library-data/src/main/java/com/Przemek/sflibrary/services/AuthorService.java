package com.Przemek.sflibrary.services;

import com.Przemek.sflibrary.model.Author;

import java.util.List;

public interface AuthorService extends CrudService<Author, Long> {

    Author findByLastName(String lastName);

    List<Author> findAllByLastName(String lastName);

}
