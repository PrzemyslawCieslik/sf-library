package com.Przemek.sflibrary.services.springdatajpa;

import com.Przemek.sflibrary.model.Book;
import com.Przemek.sflibrary.repositories.BookRepository;
import com.Przemek.sflibrary.services.BookService;

import java.util.HashSet;
import java.util.Set;

public class BookSDJpaService implements BookService {

    private final BookRepository bookRepository;


    public BookSDJpaService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @Override
    public Set<Book> findAll() {
        Set<Book> books = new HashSet<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }

    @Override
    public Book findById(Long aLong) {
        return bookRepository.findById(aLong).orElse(null);
    }

    @Override
    public Book save(Book object) {
        return bookRepository.save(object);
    }

    @Override
    public void delete(Book object) {
        bookRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        bookRepository.deleteById(aLong);
    }
}
