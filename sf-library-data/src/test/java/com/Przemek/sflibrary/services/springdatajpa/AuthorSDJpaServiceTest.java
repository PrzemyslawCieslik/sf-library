package com.Przemek.sflibrary.services.springdatajpa;

import com.Przemek.sflibrary.model.Author;
import com.Przemek.sflibrary.repositories.AuthorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthorSDJpaServiceTest {

    @Mock
    AuthorRepository authorRepository;

    @InjectMocks
    AuthorSDJpaService service;

    Author returnedAuthor;
    private final String LAST_NAME = "Smith";

    @BeforeEach
    void setUp() {
        returnedAuthor=Author.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(authorRepository.findByLastName(any())).thenReturn(returnedAuthor);

        Author smith = service.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, smith.getLastName());
    }

    @Test
    void findAllByLastName() {

    }

    @Test
    void findAll() {
        Set<Author> returnAuthorSet = new HashSet<>();
        returnAuthorSet.add(Author.builder().id(1L).build());
        returnAuthorSet.add(Author.builder().id(2L).build());

        when(authorRepository.findAll()).thenReturn(returnAuthorSet);

        Set<Author> authors = service.findAll();

        assertEquals(2, authors.size());
        assertNotNull(authors);
    }

    @Test
    void findById() {
        when(authorRepository.findById(any())).thenReturn(Optional.of(returnedAuthor));

        Author author = service.findById(1L);

        assertEquals(1L, author.getId());
        assertNotNull(author);
    }

    @Test
    void save() {
        Author authorToSave = Author.builder().id(1L).build();

        when(authorRepository.save(any())).thenReturn(authorToSave);

        Author savedAuthor = service.save(authorToSave);

        assertNotNull(savedAuthor);

        verify(authorRepository).save(any());
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}