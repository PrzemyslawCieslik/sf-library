package com.Przemek.sflibrary.repositories;

import com.Przemek.sflibrary.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

    Book findByIsbn(String isbn);

}
