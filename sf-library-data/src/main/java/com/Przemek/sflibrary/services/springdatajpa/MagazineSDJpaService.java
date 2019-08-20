package com.Przemek.sflibrary.services.springdatajpa;

import com.Przemek.sflibrary.model.Magazine;
import com.Przemek.sflibrary.repositories.MagazineRepository;
import com.Przemek.sflibrary.services.MagazineService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MagazineSDJpaService implements MagazineService {

    private final MagazineRepository magazineRepository;

    public MagazineSDJpaService(MagazineRepository magazineRepository) {
        this.magazineRepository = magazineRepository;
    }

    @Override
    public List<Magazine> findAllByLanguage(String language) {
        return magazineRepository.findAllByLanguage(language);
    }

    @Override
    public Set<Magazine> findAll() {
        Set<Magazine> magazines = new HashSet<>();
        magazineRepository.findAll().forEach(magazines::add);
        return magazines;
    }

    @Override
    public Magazine findById(Long aLong) {
        return magazineRepository.findById(aLong).orElse(null);
    }

    @Override
    public Magazine save(Magazine object) {
        return magazineRepository.save(object);
    }

    @Override
    public void delete(Magazine object) {
        magazineRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        magazineRepository.deleteById(aLong);
    }
}
