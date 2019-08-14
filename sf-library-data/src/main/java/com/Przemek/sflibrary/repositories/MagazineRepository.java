package com.Przemek.sflibrary.repositories;

import com.Przemek.sflibrary.model.Magazine;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MagazineRepository extends CrudRepository<Magazine, Long> {
    List<Magazine> findAllByLanguage(String language);
}
