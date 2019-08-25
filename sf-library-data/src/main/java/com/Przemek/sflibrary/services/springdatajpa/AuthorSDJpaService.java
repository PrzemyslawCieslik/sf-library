package com.Przemek.sflibrary.services.springdatajpa;

import com.Przemek.sflibrary.model.Author;
import com.Przemek.sflibrary.repositories.AuthorRepository;
import com.Przemek.sflibrary.services.AuthorService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Profile("springdatajpa")
@Service
public class AuthorSDJpaService implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorSDJpaService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author findByLastName(String lastName) {
        return authorRepository.findByLastName(lastName);
    }

    @Override
    public List<Author> findAllByLastName(String lastName) {
        return authorRepository.findAllByLastName(lastName);
    }

    @Override
    public Set<Author> findAll() {
        Set<Author> authors = new HashSet<>();
        authorRepository.findAll().forEach(authors::add);
        return authors;
    }

    @Override
    public Author findById(Long aLong) {
        return authorRepository.findById(aLong).orElse(null);
    }

    @Override
    public Author save(Author object) {
        return authorRepository.save(object);
    }

    @Override
    public void delete(Author object) {
        authorRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        authorRepository.deleteById(aLong);
    }
}
