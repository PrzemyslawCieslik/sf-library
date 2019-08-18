package com.Przemek.sflibrary.repositories;


import com.Przemek.sflibrary.model.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    Author findByLastName(String lastName);

    List<Author> findAllByLastName(String lastName);

    Set<Author> findAll(Long aLong);
}
