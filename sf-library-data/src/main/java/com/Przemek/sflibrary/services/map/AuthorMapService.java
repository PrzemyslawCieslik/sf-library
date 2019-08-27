package com.Przemek.sflibrary.services.map;

import com.Przemek.sflibrary.model.Author;
import com.Przemek.sflibrary.services.AuthorService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Profile("default")
@Service
public class AuthorMapService extends MapService<Author, Long> implements AuthorService {

    @Override
    public Author findByLastName(String lastName) {
        return this.findAll()
                .stream()
                .filter(author -> author.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Author> findAllByLastName(String lastName) {
        return null;
    }

    @Override
    public Set<Author> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Author object) {
        super.delete(object);
    }

    @Override
    public Author save(Author object) {
        return super.save(object);
    }

    @Override
    public Author findById(Long id) {
        return super.findById(id);
    }
}
