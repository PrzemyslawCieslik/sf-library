package com.Przemek.sflibrary.services;

import com.Przemek.sflibrary.model.Book;

public interface BookService extends CrudService<Book, Long> {

    Book findByIsbn(String isbn);




}
