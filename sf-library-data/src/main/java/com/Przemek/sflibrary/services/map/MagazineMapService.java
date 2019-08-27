package com.Przemek.sflibrary.services.map;

import com.Przemek.sflibrary.model.Magazine;
import com.Przemek.sflibrary.services.MagazineService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Profile("default")
@Service
public class MagazineMapService extends MapService<Magazine, Long> implements MagazineService {

    @Override
    public List<Magazine> findAllByLanguage(String language) {
        return this.findAllByLanguage(language);
        //TODO Create logic and throw an exception
    }

    @Override
    public Set<Magazine> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Magazine object) {
        super.delete(object);
    }

    @Override
    public Magazine save(Magazine object) {
        return super.save(object);
    }

    @Override
    public Magazine findById(Long id) {
        return super.findById(id);
    }
}
