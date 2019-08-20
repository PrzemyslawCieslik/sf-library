package com.Przemek.sflibrary.repositories;


import com.Przemek.sflibrary.model.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    Author findByLastName(String lastName);

    List<Author> findAllByLastName(String lastName);
}
