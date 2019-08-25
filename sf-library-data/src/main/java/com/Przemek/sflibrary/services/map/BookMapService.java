package com.Przemek.sflibrary.services.map;

import com.Przemek.sflibrary.model.Book;
import com.Przemek.sflibrary.services.BookService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Profile("default")
@Service
public class BookMapService extends MapService<Book, Long> implements BookService {

    private final BookService bookService;

    public BookMapService(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public Book findByIsbn(String isbn) {
        return this.findByIsbn(isbn);
        //TODO Create logic and throw an exception
    }

    @Override
    public Set<Book> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Book object) {
        super.delete(object);
    }

    @Override
    public Book save(Book object) {
        return super.save(object);
    }

    @Override
    public Book findById(Long id) {
        return super.findById(id);
    }
}
